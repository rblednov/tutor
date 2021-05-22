package ru.rblednov.tutors.messagerenderer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rblednov.tutors.messageprovider.MessageProvider;
@Service("renderer")
public class SysOutMessageRenderer implements MessageRenderer {
    MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("qwe");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
