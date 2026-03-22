package AbstractFactory;

import AbstractFactory.StyleA.AFactory;
import AbstractFactory.StyleB.BFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UIFactory factory = null;

        System.out.println("Choose an UI style:");
        System.out.println("1. Simple style");
        System.out.println("2. Crazy style");

        int styleChoice = scanner.nextInt();
        scanner.nextLine();

        // define the factory on choice
        switch (styleChoice) {
            case 1:
                factory = new AFactory();
                break;
            case 2:
                factory = new BFactory();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }

        // early initialize the components
        Button button = factory.createButton("Click me");
        TextField textField = factory.createTextField("Enter text");
        Checkbox checkbox = factory.createCheckbox("I agree");

        while (true) {
            System.out.println("\nUI components:");
            System.out.println("1. Display components");
            System.out.println("2. Edit button");
            System.out.println("3. Edit text field");
            System.out.println("4. Edit checkbox");
            System.out.println("5. Exit");

            int actionChoice = scanner.nextInt();
            scanner.nextLine();

            switch (actionChoice) {
                case 1:
                    button.display();
                    textField.display();
                    checkbox.display();
                    break;
                case 2:
                    System.out.print("Enter new button text: ");
                    String buttonText = scanner.nextLine();
                    button.setText(buttonText);
                    button.display();
                    break;
                case 3:
                    System.out.print("Enter new text field text: ");
                    String textFieldText = scanner.nextLine();
                    textField.setText(textFieldText);
                    textField.display();
                    break;
                case 4:
                    System.out.print("Enter new checkbox label: ");
                    String checkboxLabel = scanner.nextLine();
                    checkbox.setText(checkboxLabel);
                    checkbox.display();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
