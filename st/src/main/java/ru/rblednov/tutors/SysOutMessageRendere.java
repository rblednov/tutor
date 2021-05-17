package ru.rblednov.tutors;

public class SysOutMessageRendere implements MessageRenderer{
    MessageProvider messageProvider;
    @Override
    public void render() {
        if(messageProvider == null){
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
