package ru.rblednov.tutors.anntoationconfigctx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rblednov.tutors.messageprovider.HWMessageProvider;
import ru.rblednov.tutors.messageprovider.MessageProvider;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;
import ru.rblednov.tutors.messagerenderer.SysOutMessageRenderer;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider() {
        return new HWMessageProvider();
    }

    @Bean(name = "renderer")
    public MessageRenderer renderer() {
        MessageRenderer renderer = new SysOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
