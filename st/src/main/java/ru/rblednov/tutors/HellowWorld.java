package ru.rblednov.tutors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;

public class HellowWorld {
    public static void main(String[] args) {
//        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
//        mr.setMessageProvider(MessageSupportFactory.getInstance().getMessageProvider());
//        mr.render();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app-context-xml.xml");
        MessageRenderer mr = applicationContext.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
