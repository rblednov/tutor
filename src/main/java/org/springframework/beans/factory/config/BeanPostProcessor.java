package org.springframework.beans.factory.config;

public interface BeanPostProcessor {
    public Object postProcessBeforeInitialisation(Object bean, String beanName);
    public Object postProcessAfterInitialisation(Object bean, String beanName);
}
