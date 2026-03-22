package Memento;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox {
    private int id;
    private Controller controller;

    private Rectangle rectangle;
    private Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};
    private int colorIndex = 0;

    public ColorBox(int id, Controller controller) {
        this.rectangle = new Rectangle(100, 100);
        this.rectangle.setFill(colors[this.colorIndex]);
        this.controller = controller;
        this.id = id;

        this.rectangle.setOnMouseClicked(e -> {
            this.changeColor();
            this.controller.setOption(this.id, this.colorIndex);
        });
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    private void changeColor() {
        this.colorIndex = (this.colorIndex + 1) % colors.length;
        this.rectangle.setFill(colors[this.colorIndex]);
    }

    public void setColor(int colorIndex) {
        this.colorIndex = colorIndex;
        this.rectangle.setFill(colors[this.colorIndex]);
    }
}
