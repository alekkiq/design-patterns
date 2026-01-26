package Decorator;

public class Main {
    public static void main(String[] args) {
        Printer printerBasic = new BasicPrinter();
        printerBasic.print("morjens");

        System.out.println();

        Printer printerCrazy = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printerCrazy.print("gambina on hyvää");
    }
}
