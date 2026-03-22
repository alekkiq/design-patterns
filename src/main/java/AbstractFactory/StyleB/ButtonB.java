package AbstractFactory.StyleB;

import AbstractFactory.Button;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        this.drawBorder('=', '*', this.text);
        System.out.println(":" + this.text + ":");
        this.drawBorder('=', '*', this.text);
    }
}
