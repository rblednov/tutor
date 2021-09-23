package ru.rblednov.tutors.selfspring;

import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.beans.factory.BeanFactory;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantinate("ru.rblednov.tutors.selfspring");
    }
}
