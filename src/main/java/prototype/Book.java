package prototype;

public class Book implements Prototype {
    private String title;
    private String author;
    private String genre;
    private int publishYear;

    public Book(String title, String author, String genre, int publishYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishYear = publishYear;
    }

    @Override
    public Book clone() {
        return new Book(this.title, this.author, this.genre, this.publishYear);
    }

    @Override
    public String toString() {
        return "Book{title: " + this.title + ", author: " + this.author + ", genre: " + this.genre + ", publishYear: " + this.publishYear + "}";
    }

    public String getTitle() { return this.title; }
    public String getAuthor() { return this.author; }
    public String getGenre() { return this.genre; }
    public int getPublishYear() { return this.publishYear; }
}
