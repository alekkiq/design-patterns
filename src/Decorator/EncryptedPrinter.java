package Decorator;

public class EncryptedPrinter extends PrinterDecorator {
    static int SHIFT_BY = 3;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    /**
     * Encrypt a string. Shift by 3 digits and reverse the string
     * @param text
     * @return encrypted string
     */
    private String encryptText(String text) {
        StringBuilder shiftedStr = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // lowercase characters
            if (c >= 'a' && c <= 'z') {
                c = (char)('a' + (c - 'a' + SHIFT_BY) % 26);
            }

            // uppercase chars
            else if (c >= 'A' && c <= 'Z') {
                c = (char)('A' + (c - 'A' + SHIFT_BY) % 26);
            }

            // lowercase chars
            else if (c >= '0' && c <= '9') {
                c = (char)('0' + (c - '0' + SHIFT_BY) % 10);
            }

            // rest of char not encrypted
            shiftedStr.append(c);
        }

        return shiftedStr.reverse().toString();
    }

    @Override
    public void print(String text) {
        super.print(this.encryptText(text));
    }
}
