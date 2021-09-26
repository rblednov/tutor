package org.springframework.beans.factory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annatation.Autowired;
import org.springframework.beans.factory.annatation.PostConstruct;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.beans.factory.stereotype.Service;

public class BeanFactory {
    Map<String, Object> singletons = new HashMap<>();
    List<BeanPostProcessor> postProcessors = new ArrayList<>();

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public void addPostProcessor(BeanPostProcessor postProcessor) {
        postProcessors.add(postProcessor);
    }

    public void injectBeanNames() {
        System.out.println("====injectBeanNames====");
        for (String name : singletons.keySet()) {
            Object singleton = singletons.get(name);
            if (singleton instanceof BeanNameAware) {
                ((BeanNameAware) singleton).setBeanName(name);
            }
        }
    }

    public void injectBeanFactory() {
        System.out.println("====injectBeanFactory====");
        for (Object object : singletons.values()) {
            if (object instanceof BeanFactoryAware) {
                ((BeanFactoryAware) object).setBeanFactory(this);
            }
        }
    }

    public void initialiseBeans() throws InvocationTargetException, IllegalAccessException {
        System.out.println("====initialiseBeans====");
        for (Map.Entry<String, Object> pair : singletons.entrySet()) {
            String name = pair.getKey();
            Object bean = pair.getValue();

            for (BeanPostProcessor postProcessor : postProcessors) {
                postProcessor.postProcessBeforeInitialisation(bean, name);
            }
            if (bean instanceof InitializingBean) {
                ((InitializingBean) bean).afterPropertiesSet();
            }
            for (BeanPostProcessor postProcessor : postProcessors) {
                postProcessor.postProcessAfterInitialisation(bean, name);
            }
        }
    }

    public void populateProperties() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("====populateProperties====");
        for (Map.Entry<String, Object> sinletonMapEntry : singletons.entrySet()) {
            for (Field field : sinletonMapEntry.getValue().getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    for (Object dependency : singletons.values()) {
                        if (field.getType().equals(dependency.getClass())) {
                            String setterName = "set" + firstLetterToUpper(field.getName());
                            System.out.println("setterName: " + setterName);
                            Method setter = sinletonMapEntry.getValue().getClass()
                                    .getMethod(setterName, dependency.getClass());
                            setter.invoke(sinletonMapEntry.getValue(), dependency);
                        }
                    }
                }
            }
        }
    }

    public void instantinate(String basePackage)
            throws IOException, URISyntaxException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("====Instantinate beans====");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String path = basePackage.replace(".", "/");
        Enumeration<URL> urlEnumeration = classLoader.getResources(path);
        while (urlEnumeration.hasMoreElements()) {
            URL resource = urlEnumeration.nextElement();
            File pack = new File(resource.toURI());
            for (File file : pack.listFiles()) {
                String fileName = file.getName();
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(0, fileName.lastIndexOf("."));
                    Class classObject = Class.forName(basePackage + "." + className);
                    if (classObject.isAnnotationPresent(Component.class)) {
                        System.out.println("Component: " + classObject);
                        Object instance = classObject.getDeclaredConstructor().newInstance();
                        String beanName = firstLetterToLower(className);
                        singletons.put(beanName, instance);
                    } else if (classObject.isAnnotationPresent(Service.class)) {
                        System.out.println("Service: " + classObject);
                        Object instance = classObject.getDeclaredConstructor().newInstance();
                        String beanName = firstLetterToLower(className);
                        singletons.put(beanName, instance);
                    }
                }
            }
        }
    }

    private String firstLetterToLower(String className) {
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

    private String firstLetterToUpper(String className) {
        return className.substring(0, 1).toUpperCase() + className.substring(1);
    }
}
