package org.springframework.beans.factory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.stereotype.Component;

public class BeanFactory {
    Map<String, Object> singletons;

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public void instantinate(String basePackage)
            throws IOException, URISyntaxException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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
                        String beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                        singletons.put(beanName, instance);
                    }
                }
            }
        }
    }
}
