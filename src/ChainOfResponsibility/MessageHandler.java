package ChainOfResponsibility;

public class MessageHandler {
    private MessageHandler nextHandler;

    public void handleMessage(Message message) {
        if (this.nextHandler != null) {
            this.nextHandler.handleMessage(message);
        }
    }

    public void setNextHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public MessageHandler getHandler() {
        return this.nextHandler;
    }
}
