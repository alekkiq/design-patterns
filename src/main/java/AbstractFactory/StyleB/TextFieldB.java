package AbstractFactory.StyleB;

import AbstractFactory.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("*");
        System.out.print(this.text);
        System.out.print("*\n");

        System.out.print(":");
        for (int i = 0; i < this.text.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(":\n");

        System.out.print("*");
        for (int i = 0; i < this.text.length(); i++) {
            System.out.print("=");
        }
        System.out.print("*\n");
    }
}
