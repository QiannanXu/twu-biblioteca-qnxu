package com.twu.biblioteca.entity;

public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private int publishedYear;
    private State bookState;

    public Book(String bookId, String bookName, String bookAuthor, int publishedYear, State bookState) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publishedYear = publishedYear;
        this.bookState = bookState;
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }

    public State getBookState() {
        return bookState;
    }

    public void setBookState(State bookState) {
        this.bookState = bookState;
    }
}
