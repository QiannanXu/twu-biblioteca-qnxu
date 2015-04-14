package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {
    private List<Book> bookList = new BookList().getBookList();

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!");
    }

    public void showBookList(){
        System.out.println("Here is the book list:");
        System.out.println("-----------------------");
        for(Book book : bookList){
            System.out.println("Name: "+book.getBookName()+"\tAuthor: "+book.getBookAuthor()+"\t"+book.getPublishedYear());
        }
    }
}
