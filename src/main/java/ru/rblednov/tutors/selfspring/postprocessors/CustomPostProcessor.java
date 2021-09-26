package ru.rblednov.tutors.selfspring.postprocessors;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialisation(Object bean, String beanName) {
        System.out.println("---Custom postProcessBeforeInitialisation " + beanName + "---");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialisation(Object bean, String beanName) {
        System.out.println("---Custom postProcessAfterInitialisation " + beanName + "---");
        return bean;
    }
}
