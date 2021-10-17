package ru.rblednov.tutors.playground;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
        applicationContext.close();
//        Thread.sleep(100000);
    }
}
