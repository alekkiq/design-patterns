package chain_of_responsibility;

public class SuggestionHandler extends MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("Handling suggestion message.");
        } else {
            super.handleMessage(message);
        }
    }
}
