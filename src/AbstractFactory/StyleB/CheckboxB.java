package AbstractFactory.StyleB;

import AbstractFactory.Checkbox;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("{");
        System.out.print(this.checked ? "V" : " ");
        System.out.print("} " + this.text + "\n");
    }
}
