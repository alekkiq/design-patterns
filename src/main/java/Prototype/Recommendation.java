package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    @Override
    public Recommendation clone() {
        List<Book> clonedBooks = new ArrayList<>();

        for (Book book : this.books) {
            clonedBooks.add(book.clone());
        }

        return new Recommendation(this.targetAudience, clonedBooks);
    }

    @Override
    public String toString() {
        return "Recommendation{targetAudience: " + this.getTargetAudience() + ", books: " + this.books + "}";
    }

    public String getTargetAudience() { return this.targetAudience; }
    public void setTargetAudience(String targetAudience) { this.targetAudience = targetAudience; }
    public List<Book> getBooks() { return new ArrayList<>(this.books); }
    public void addBook(Book book) { this.books.add(book); }
    public void removeBook(Book book) { this.books.remove(book); }
}
