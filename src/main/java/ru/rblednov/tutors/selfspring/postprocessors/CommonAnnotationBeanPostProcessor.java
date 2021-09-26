package ru.rblednov.tutors.selfspring.postprocessors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annatation.PostConstruct;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CommonAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialisation(Object bean, String beanName) {
        for (Method method : bean.getClass().getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                try {
                    method.invoke(bean, method.getParameters());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialisation(Object bean, String beanName) {
        return bean;
    }
}
