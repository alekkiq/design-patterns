package Memento;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow {
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
    }

    public void show() {
        Stage stage = new Stage();
        ListView<IMemento> listView = new ListView<>();
        listView.getItems().setAll(this.controller.getTimeline());

        Button restore = new Button("Restore");

        restore.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                this.controller.restoreHistoryPoint(index);
            }
        });

        VBox root = new VBox(listView, restore);
        stage.setScene(new Scene(root, 420, 400));
        stage.setTitle("History");
        stage.show();
    }
}
