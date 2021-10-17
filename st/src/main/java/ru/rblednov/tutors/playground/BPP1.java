package ru.rblednov.tutors.playground;

import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BPP1 implements BeanPostProcessor, BeanFactoryPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before creating bean: " + beanName);
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        System.out.println("BeanPostProcessor \n    "+ List.of(configurableListableBeanFactory.getBeanDefinitionNames()));
    }
}
