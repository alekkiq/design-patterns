package AbstractFactory;

public abstract class Button extends UIElement {
    public abstract void display();

    public Button(String text) {
        super(text);
    }

    protected void drawBorder(char lineChar, char cornerChar, String text) {
        System.out.print(cornerChar);
        for (int i = 0; i < text.length(); i++) {
            System.out.print(lineChar);
        }
        System.out.print(cornerChar + "\n");
    }
}
