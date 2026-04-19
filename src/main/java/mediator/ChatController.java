package mediator;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mediator.mediator.ChatMediator;
import mediator.mediator.ChatParticipant;

import java.util.Set;

public class ChatController implements ChatParticipant {
    private String username;
    private ChatMediator mediator;

    private final TextArea chatArea = new TextArea();
    private final TextField inputField = new TextField();
    private final ComboBox<String> recipientBox = new ComboBox<>();
    private final Button sendButton = new Button("Send");

    public ChatController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;

        this.mediator.register(this);

        // set up the controls
        this.chatArea.setEditable(false);
        this.chatArea.setPromptText("Chats will appear here...");
        this.inputField.setPromptText("Type your message here...");
        this.recipientBox.setPromptText("Select recipient");

        this.sendButton.setOnAction(e -> {
            String message = this.inputField.getText();
            String recipient = this.recipientBox.getValue();

            if (message != null && recipient != null) {
                sendMessage(message, recipient);
                this.chatArea.appendText("You -> " + recipient + ": " + message + "\n");
                this.inputField.clear();
            }
        });
    }

    public void updateRecipients(Set<String> users) {
        this.recipientBox.getItems().clear();

        for (String user : users) {
            if (!user.equals(this.username)) {
                this.recipientBox.getItems().add(user);
            }
        }
    }

    @Override
    public void sendMessage(String message, String recipient) {
        this.mediator.sendMessage(message, this, recipient);
    }

    @Override
    public void receiveMessage(String message, String sender) {
        this.chatArea.appendText(sender + " -> You: " + message + "\n");
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public TextArea getChatArea() {
        return this.chatArea;
    }

    public TextField getInputField() {
        return this.inputField;
    }

    public ComboBox<String> getRecipientBox() {
        return this.recipientBox;
    }

    public Button getSendButton() {
        return this.sendButton;
    }
}
