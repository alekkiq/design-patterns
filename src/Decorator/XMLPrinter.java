package Decorator;

public class XMLPrinter extends PrinterDecorator {
    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        String output = "<message>" + text + "</message>";
        super.print(output);
    }
}
