package ru.rblednov.tutors.selfspring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import org.springframework.beans.factory.BeanFactory;

public class Main {
    public static void main(String[] args)
            throws IOException, URISyntaxException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.instantinate("ru.rblednov.tutors.selfspring");
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.injectBeanFactory();
        beanFactory.initialiseBeans();
        ProductService productService = (ProductService) beanFactory.getBean("productService");

        System.out.println("Bean name = " + productService.getPromotionService().getBeanName());


    }
}
