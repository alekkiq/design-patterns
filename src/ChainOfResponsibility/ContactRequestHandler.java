package ChainOfResponsibility;

public class ContactRequestHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Handling contact request message.");
        } else {
            super.handleMessage(message);
        }
    }
}
