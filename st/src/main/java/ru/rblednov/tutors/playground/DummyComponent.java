package ru.rblednov.tutors.playground;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DummyComponent implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("see u");
    }
}
