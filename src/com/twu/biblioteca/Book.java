package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int publishedYear;

    public Book(String bookName, String bookAuthor, int publishedYear) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publishedYear = publishedYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
