package AbstractFactory.StyleA;

import AbstractFactory.Checkbox;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.print("[");
        System.out.print(this.checked ? "X" : " ");
        System.out.print("] " + this.text + "\n");
    }
}
