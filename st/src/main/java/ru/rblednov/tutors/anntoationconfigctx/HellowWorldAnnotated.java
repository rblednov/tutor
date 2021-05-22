package ru.rblednov.tutors.anntoationconfigctx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;

public class HellowWorldAnnotated {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = applicationContext.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
