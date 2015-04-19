package com.twu.biblioteca;

import com.twu.biblioteca.processor.CheckBookProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private List<Book> availableBookList;
    private List<Book> checkedOutBookList;

    private CheckBookProcessor checkBookProcessor;

    public BibliotecaApp(CheckBookProcessor checkBookProcessor) {
        this.checkBookProcessor = checkBookProcessor;
    }

    public BibliotecaApp(List<Book> availableBookList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = new ArrayList<>();
    }

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!\n");
        System.out.println("Please Select an Option:");
        System.out.println("---------------------------------------------");
        System.out.println("1.List Books");
        System.out.println("2.Check Out Books");
        System.out.println("3.Return Books");
        System.out.println("4.Quit");
        System.out.println("---------------------------------------------");
    }


    public void executeSelectedOption() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String option = scanner.next();
            switch (option) {
                case "1":
                    checkBookProcessor.showAvailableBookList();
                    break;
                case "2":
                    showCheckOutOptions();
                    break;
                case "3":
                    showReturnBookOptions();
                    break;
                case "4":
                    quit();
                    break;
                default:
                    showErroMessage();
            }
        }
    }

    private void showCheckOutOptions() {
        checkBookProcessor.showAvailableBookList();

        System.out.println("Please Select Book Number You Want To Check Out:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        checkOutTheSelectedBook(scanner.next());

    }

    private void showReturnBookOptions() {
        checkBookProcessor.showCheckedOutBookList();

        System.out.println("Please Select Book Number You Want To Return:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        returnTheSelectedBook(scanner.next());
    }

    private void checkOutTheSelectedBook(String option) {
        for(Book book : availableBookList){
            if(book.getBookId().equals(option)){
                book.setBookState(BookState.CHECKED_OUT);
                checkedOutBookList.add(book);
                availableBookList.remove(book);
                System.out.println("Thank you! Enjoy the book.");
                System.out.println();
                showWelcomePage();
                return;
            }
        }

        System.out.println("That book is not available.\n");
        showCheckOutOptions();
    }

    private void returnTheSelectedBook(String option) {
        for(Book book : checkedOutBookList){
            if(book.getBookId().equals(option)){
                book.setBookState(BookState.CHECKED_IN);
                checkedOutBookList.remove(book);
                availableBookList.add(book);
                System.out.println("Thank you for returning the book.");
                System.out.println();
                showWelcomePage();
                return;
            }
        }

        System.out.println("That is not a valid book to return.\n");
        showReturnBookOptions();
    }

    public void showErroMessage() {
        System.out.println("Select a valid option!");
    }


    private void quit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BookList().getBookList());
        bibliotecaApp.showWelcomePage();
        bibliotecaApp.executeSelectedOption();
    }
}
