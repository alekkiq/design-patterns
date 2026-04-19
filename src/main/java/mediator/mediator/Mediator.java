package mediator.mediator;

public interface Mediator {
    void sendMessage(String message, ChatParticipant sender, String recipient);
    void register(ChatParticipant participant);
}
