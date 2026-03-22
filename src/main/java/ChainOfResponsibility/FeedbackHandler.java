package ChainOfResponsibility;

public class FeedbackHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.FEEDBACK) {
            System.out.println("Handling feedback message.");
        } else {
            super.handleMessage(message);
        }
    }
}
