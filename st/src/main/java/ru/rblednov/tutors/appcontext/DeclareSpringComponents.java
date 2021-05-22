package ru.rblednov.tutors.appcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("classpath:spring/app-context-annotation.xml");
        applicationContext.refresh();
        applicationContext.getBean("renderer", MessageRenderer.class).render();
    }
}
