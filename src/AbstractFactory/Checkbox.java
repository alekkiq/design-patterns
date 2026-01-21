package AbstractFactory;

public abstract class Checkbox extends UIElement {
    protected boolean checked = false;

    public Checkbox(String text) {
        super(text);
    }

    public abstract void display();
}
