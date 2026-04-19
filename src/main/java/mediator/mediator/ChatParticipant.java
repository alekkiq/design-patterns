package mediator.mediator;

public interface ChatParticipant {
    void sendMessage(String message, String recipient);
    void receiveMessage(String message, String sender);
    String getUsername();
}
