package ChainOfResponsibility;

public class CompensationClaimHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim message.");
        } else {
            super.handleMessage(message);
        }
    }
}
