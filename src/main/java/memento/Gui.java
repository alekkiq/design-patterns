package memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        this.controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        this.colorBox1 = new ColorBox(1, this.controller);
        this.colorBox2 = new ColorBox(2, this.controller);
        this.colorBox3 = new ColorBox(3, this.controller);

        // Create a CheckBox
        this.checkBox = new CheckBox("Click me!");
        this.checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(this.colorBox1.getRectangle(), this.colorBox2.getRectangle(), this.colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(this.colorBox1.getRectangle(), insets);
        hBox.setMargin(this.colorBox2.getRectangle(), insets);
        hBox.setMargin(this.colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);

        Label label2 = new Label("Press Ctrl-Y to redo the last undone change.");
        label2.setPadding(insets);

        Button historyBtn = new Button("Show History");
        historyBtn.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, this.checkBox, label, label2, historyBtn);
        // call controller when the CheckBox is clicked
        this.checkBox.setOnAction(event -> {
            this.controller.setIsSelected(this.checkBox.isSelected());
        });

        historyBtn.setOnMouseClicked(event -> new HistoryWindow(this.controller).show());

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                this.controller.undo();
            }
            if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                this.controller.redo();
            }
        });


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        this.colorBox1.setColor(this.controller.getOption(1));
        this.colorBox2.setColor(this.controller.getOption(2));
        this.colorBox3.setColor(this.controller.getOption(3));
        this.checkBox.setSelected(this.controller.getIsSelected());
    }
}
