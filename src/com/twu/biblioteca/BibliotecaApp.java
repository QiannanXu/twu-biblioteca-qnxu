package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {
    private List<Book> bookList = new BookList().getBookList();

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!");
    }

    public void showBookList(){
        System.out.println("Here is the book list:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-20s", "Name");
        System.out.printf("%-20s", "Author");
        System.out.printf("%-20s", "Year");
        System.out.printf("\n");
        System.out.println("---------------------------------------------");

        for(Book book : bookList){
            System.out.printf("%-20s", book.getBookName());
            System.out.printf("%-20s", book.getBookAuthor());
            System.out.printf("%-20s", book.getPublishedYear());
            System.out.printf("\n");
//            System.out.println("Name: "+book.getBookName()+"\tAuthor: "+book.getBookAuthor()+"\t"+book.getPublishedYear());
        }
    }


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showWelcomePage();
        bibliotecaApp.showBookList();
    }
}
