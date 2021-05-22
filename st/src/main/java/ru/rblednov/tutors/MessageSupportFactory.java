package ru.rblednov.tutors;

import java.io.IOException;
import java.util.Properties;
import ru.rblednov.tutors.messageprovider.MessageProvider;
import ru.rblednov.tutors.messagerenderer.MessageRenderer;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties props;
    MessageRenderer messageRenderer;
    MessageProvider messageProvider;

    private MessageSupportFactory() {
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String renderClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            messageRenderer = (MessageRenderer) Class.forName(renderClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
