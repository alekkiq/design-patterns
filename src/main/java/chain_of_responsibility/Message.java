package chain_of_responsibility;

public class Message {
    private MessageType type;
    private String content;
    private String senderEmail;

    public Message(MessageType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public MessageType getType() {
        return this.type;
    }

    public String getContent() {
        return this.content;
    }

    public String getSenderEmail() {
        return this.senderEmail;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
