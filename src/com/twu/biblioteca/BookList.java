package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private static List<Book> bookList;

    static {
        bookList = new ArrayList(){{
            add(new Book("1", "Refactoring", "Martin Flower", 2012));
            add(new Book("2", "TDD", "Kent Beck", 2003));
            add(new Book("3", "Thinking in Java", "Bruce Eckel", 2006));
        }};
    }

    public List<Book> getBookList(){
        return bookList;
    }
}
