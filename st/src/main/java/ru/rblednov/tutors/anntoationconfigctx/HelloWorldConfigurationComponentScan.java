package ru.rblednov.tutors.anntoationconfigctx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.rblednov.tutors.messageprovider.HWMessageProvider;
import ru.rblednov.tutors.messageprovider.MessageProvider;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;
import ru.rblednov.tutors.messagerenderer.SysOutMessageRenderer;

@Configuration
@ComponentScan(basePackages = "ru.rblednov.tutors")
public class HelloWorldConfigurationComponentScan {
}
