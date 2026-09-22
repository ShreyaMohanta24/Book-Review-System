package models;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String genre;

    public Book(int bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               "\nTitle: " + title +
               "\nAuthor: " + author +
               "\nGenre: " + genre;
    }
}