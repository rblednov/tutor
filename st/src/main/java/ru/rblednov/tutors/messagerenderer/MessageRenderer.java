package ru.rblednov.tutors.messagerenderer;

import ru.rblednov.tutors.messageprovider.MessageProvider;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();
}
