package com.twu.biblioteca;

public class BibliotecaApp {
    private String[] bookList = {"Refactoring", "TDD", "Thinking in Java"};

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!");
    }

    public void showBookList(){
        System.out.println("Here is the book list:");
        for(int i=0; i<bookList.length; i++){
            System.out.println(bookList[i]);
        }
    }
}
