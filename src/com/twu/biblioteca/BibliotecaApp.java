package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private List<Book> bookList = new BookList().getBookList();

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!\n");
        showSelectMenuOptions();
    }

    public void showBookList(){
        System.out.println("Here is the book list:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-5s", "Id");
        System.out.printf("%-20s", "Name");
        System.out.printf("%-20s", "Author");
        System.out.printf("%-20s", "Year");
        System.out.printf("\n");
        System.out.println("---------------------------------------------");

        for(Book book : bookList){
            System.out.printf("%-5s", book.getBookId());
            System.out.printf("%-20s", book.getBookName());
            System.out.printf("%-20s", book.getBookAuthor());
            System.out.printf("%-20s", book.getPublishedYear());
            System.out.println();;
        }
        System.out.println("---------------------------------------------");
    }


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showWelcomePage();
        bibliotecaApp.executeSelectedOption();
    }

    public void executeSelectedOption() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String option = scanner.next();
            switch (option) {
                case "1":
                    showBookList();
                    break;
                case "2":
                    showCheckOutOptions();
                    break;
                case "3":
                    quit();
                    break;
                default:
                    showErroMessage();
            }
        }
    }

    private void showCheckOutOptions() {
        showBookList();

        System.out.println("Please Select Book Number You Want To Check Out:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        checkOutTheSelectedBook(scanner.next());

    }

    private void checkOutTheSelectedBook(String option) {
        for(Book book : bookList){
            if(book.getBookId().equals(option)){
                book.setBookState(BookState.CHECKED_OUT);
                System.out.println("Thank you! Enjoy the book.");
                System.out.println();
                showWelcomePage();
                return;
            }
        }

        System.out.println("That book is not available.\n");
        showCheckOutOptions();
    }

    public void showSelectMenuOptions() {
        System.out.println("Please Select an Option:");
        System.out.println("---------------------------------------------");
        System.out.println("1.List Books");
        System.out.println("2.Check Out Books");
        System.out.println("3.Quit");
        System.out.println("---------------------------------------------");
    }


    public void showErroMessage() {
        System.out.println("Select a valid option!");
    }

    private void quit() {
        System.exit(0);
    }
}
