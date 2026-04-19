package mediator.mediator;

import java.util.Map;
import java.util.HashMap;

public class ChatMediator implements Mediator {
    private final Map<String, ChatParticipant> participants = new HashMap<>();

    @Override
    public void register(ChatParticipant participant) {
        this.participants.put(participant.getUsername(), participant);
    }

    @Override
    public void sendMessage(String message, ChatParticipant sender, String recipient) {
        ChatParticipant receiver = this.participants.get(recipient);
        if (receiver != null) {
            receiver.receiveMessage(message, sender.getUsername());
        }
    }

    public Map<String, ChatParticipant> getParticipants() {
        return this.participants;
    }
}
