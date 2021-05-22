package ru.rblednov.tutors.messageprovider;

import org.springframework.stereotype.Component;

@Component("provider")
public class HWMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
