package mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mediator.mediator.ChatMediator;
import mediator.mediator.ChatParticipant;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatMediator();

        createChatWindow("Aleksi", mediator, 100, 100);
        createChatWindow("Pekka", mediator, 400, 100);
        createChatWindow("Matti", mediator, 700, 100);

        updateRecipients(mediator);
    }

    private void createChatWindow(String username, ChatMediator mediator, int x, int y) {
        ChatController controller = new ChatController(username, mediator);

        VBox layout = new VBox(
            controller.getChatArea(),
            controller.getRecipientBox(),
            controller.getInputField(),
            controller.getSendButton()
        );

        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);
        stage.setScene(new Scene(layout, 300, 240));
        stage.setX(x);
        stage.setY(y);
        stage.show();
    }

    private void updateRecipients(ChatMediator mediator) {
        for (ChatParticipant participant : mediator.getParticipants().values()) {
            if (participant instanceof ChatController controller) {
                controller.updateRecipients(mediator.getParticipants().keySet());
            }
        }
    }
}
