package ru.rblednov.tutors.selfspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.stereotype.Service;

@Service
public class PromotionService implements BeanNameAware, BeanFactoryAware {
    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public String toString() {
        return "PromotionService{}";
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
