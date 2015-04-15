package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

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
        }
    }


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showWelcomePage();
        bibliotecaApp.showMenu();
    }

    public void showMenu() {
        System.out.println("Please Select an Option:");
        System.out.println("---------------------------------------------");
        System.out.println("1.List Books");

        selectMenuOption();
    }

    private void selectMenuOption() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    showBookList();
                    break;
            }
        }
    }
}
