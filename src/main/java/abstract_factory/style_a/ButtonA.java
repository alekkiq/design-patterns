package abstract_factory.style_a;

import abstract_factory.Button;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        this.drawBorder('-', '+', this.text);
        System.out.println("|" + this.text + "|");
        this.drawBorder('-', '+', this.text);
    }
}
