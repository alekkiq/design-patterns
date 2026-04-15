package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        MessageHandler compensationClaimHandler = new CompensationClaimHandler();
        MessageHandler suggestionHandler = new SuggestionHandler();
        MessageHandler feedbackHandler = new FeedbackHandler();
        MessageHandler contactRequestHandler = new ContactRequestHandler();

        // define the chain
        compensationClaimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        // hard coded messages for test
        Message[] messages = {
            new Message(MessageType.COMPENSATION_CLAIM, "My order arrived damaged.", "alice@example.com"),
            new Message(MessageType.CONTACT_REQUEST, "I need help with my account.", "bob@example.com"),
            new Message(MessageType.SUGGESTION, "You should add a dark mode.", "carol@example.com"),
            new Message(MessageType.FEEDBACK, "Great service overall!", "dave@example.com")
        };

        // start the chain
        for (Message message : messages) {
            compensationClaimHandler.handleMessage(message);
            System.out.println();
        }
    }
}
