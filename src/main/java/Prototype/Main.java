package Prototype;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Dune", "Frank Herbert", "Sci-Fi", 1965);
        Book b2 = new Book("Design Patterns", "Erich Gamma", "Programming", 1994);

        Recommendation recommendation = new Recommendation("");
        recommendation.addBook(b2);

        Recommendation clonedRecommendation = recommendation.clone();

        System.out.println(recommendation);
        System.out.println(clonedRecommendation);
    }
}
