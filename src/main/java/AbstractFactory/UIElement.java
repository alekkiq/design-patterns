package AbstractFactory;

public abstract class UIElement {
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
