package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // "Existing recommendations"
        List<Recommendation> recommendations = new ArrayList<>();

        Recommendation sciFi = new Recommendation("Sci-Fi fans");
        sciFi.addBook(new Book("Dune", "Frank Herbert", "Sci-Fi", 1965));
        sciFi.addBook(new Book("Neuromancer", "William Gibson", "Sci-Fi", 1984));

        Recommendation programming = new Recommendation("Programming students");
        programming.addBook(new Book("Design Patterns", "Erich Gamma", "Programming", 1994));
        programming.addBook(new Book("Clean Code", "Robert C. Martin", "Programming", 2008));

        recommendations.add(sciFi);
        recommendations.add(programming);

        Recommendation lastClone = null;

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Prototype Demo: Book Recommendations ===");
                System.out.println("1) Show existing recommendations");
                System.out.println("2) Clone recommendation #1 or #2");
                System.out.println("3) Modify the last clone (change audience + add a book)");
                System.out.println("4) Show original vs clone (proof)");
                System.out.println("0) Exit");
                System.out.print("Choose: ");

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        printRecommendations("Existing recommendations", recommendations);
                    }
                    case "2" -> {
                        System.out.print("Clone which one (1 or 2)? ");
                        int index = readInt(sc) - 1;
                        if (index < 0 || index >= recommendations.size()) {
                            System.out.println("Invalid selection.");
                            break;
                        }

                        Recommendation original = recommendations.get(index);
                        lastClone = original.clone();

                        System.out.println("Cloned recommendation created.");
                        System.out.println("Original: " + original);
                        System.out.println("Clone:    " + lastClone);
                    }
                    case "3" -> {
                        if (lastClone == null) {
                            System.out.println("Clone something first (option 2).");
                            break;
                        }

                        System.out.print("New target audience for clone: ");
                        String audience = sc.nextLine().trim();
                        if (!audience.isEmpty()) lastClone.setTargetAudience(audience);

                        System.out.println("Add one book to the clone:");
                        System.out.print("Title: ");
                        String title = sc.nextLine().trim();
                        System.out.print("Author: ");
                        String author = sc.nextLine().trim();
                        System.out.print("Genre: ");
                        String genre = sc.nextLine().trim();
                        System.out.print("Year: ");
                        int year = readInt(sc);

                        lastClone.addBook(new Book(title, author, genre, year));
                        System.out.println("Clone modified: " + lastClone);
                    }
                    case "4" -> {
                        if (lastClone == null) {
                            System.out.println("Clone something first (option 2).");
                            break;
                        }

                        System.out.println("\nPROOF (Originals should be unchanged)");
                        printRecommendations("Original recommendations", recommendations);
                        System.out.println("Last clone (separate object): " + lastClone);
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }

    private static void printRecommendations(String header, List<Recommendation> recommendations) {
        System.out.println("\n" + header + ":");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println((i + 1) + ") " + recommendations.get(i));
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a number: ");
            }
        }
    }
}
