package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.MovieRating;
import com.twu.biblioteca.entity.State;
import com.twu.biblioteca.processor.CheckBookProcessor;
import com.twu.biblioteca.processor.CheckMovieProcessor;
import com.twu.biblioteca.service.InputScanner;
import com.twu.biblioteca.user.LoginStorage;
import com.twu.biblioteca.user.UserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private String loginNumber;
    private CheckBookProcessor checkBookProcessor;
    private CheckMovieProcessor checkMovieProcessor;

    public BibliotecaApp(CheckBookProcessor checkBookProcessor, CheckMovieProcessor checkMovieProcessor) {
        loginNumber = "";
        this.checkBookProcessor = checkBookProcessor;
        this.checkMovieProcessor = checkMovieProcessor;
    }

    public boolean login(String libraryNumber, String password){
//        actually this message should be stored in database
        if(new LoginStorage().exists(libraryNumber, password)){
            loginNumber = "123-1234";
            return true;
        }
        return false;
    }

    public void showWelcomePage() {
        System.out.println("Welcome to Biblioteca Library!\n");
        System.out.println("Please Login");
        System.out.println("---------------------------------------------");
        System.out.println("Please Input Library Number:");

        Scanner scanner = new Scanner(System.in);
        String libraryNumber = scanner.next();
        System.out.println("Please Input Password:");
        String password = scanner.next();

        if(login(libraryNumber, password)){
            showSelectOptionAfterLogin();
        }else{
            System.out.println("Information error, please login again!");
            showLoginOption();
        }

    }

    private void showLoginOption() {
        System.out.println("Please Login");
        System.out.println("---------------------------------------------");
        System.out.println("Please Input Library Number:");
        Scanner scanner = new Scanner(System.in);
        String libraryNumber = scanner.next();
        System.out.println("Please Input Password:");
        String password = scanner.next();

        if(login(libraryNumber, password)){
            showSelectOptionAfterLogin();
        }else{
            System.out.println("Information error, please login again!");
            showLoginOption();
        }

    }

    private void showSelectOptionAfterLogin() {
        System.out.println("Please Select an Option:");
        System.out.println("---------------------------------------------");
        System.out.println("1.List Books");
        System.out.println("2.Check Out Books");
        System.out.println("3.Return Books");
        System.out.println("4.List Movies");
        System.out.println("5.Check Out Movies");
        System.out.println("6.Return Movies");
        System.out.println("7.User Profile");
        System.out.println("8.Quit");
        System.out.println("---------------------------------------------");

        executeSelectedOption();
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
                    showCheckOutBookOptions();
                    break;
                case "3":
                    showReturnBookOptions();
                    break;
                case "4":
                    checkMovieProcessor.showAvailableMovieList();
                    break;
                case "5":
                    showCheckOutMovieOptions();
                    break;
                case "6":
                    showReturnMovieOptions();
                    break;
                case "7":
                    showUserProfile();
                    break;
                case "8":
                    quit();
                    break;
                default:
                    showErrorMessage();
                    break;
            }
        }
    }

    private void showUserProfile() {
        System.out.println(new UserStorage().showUser(loginNumber));
    }

    private void showCheckOutBookOptions() {
        checkBookProcessor.showAvailableBookList();

        System.out.println("Please Select Book Number You Want To Check Out:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        checkOutTheSelectedBook(scanner.next());
    }

    private void showCheckOutMovieOptions() {
        checkMovieProcessor.showAvailableMovieList();

        System.out.println("Please Input Movie Name You Want To Check Out:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        checkOutTheSelectedMovie(scanner.next());
    }

    private void showReturnBookOptions() {
        checkBookProcessor.showCheckedOutBookList();

        System.out.println("Please Select Book Number You Want To Return:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        returnTheSelectedBook(scanner.next());
    }

    private void showReturnMovieOptions() {
        checkMovieProcessor.showCheckedOutMovieList();

        System.out.println("Please Input Movie Name You Want To Return:");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        returnTheSelectedMovie(scanner.next());
    }

    private void checkOutTheSelectedBook(String bookId) {
        if(checkBookProcessor.checkOutBook(bookId)){
            System.out.println("Thank you! Enjoy the book.\n");
            showWelcomePage();
            return;
        }

        System.out.println("That book is not available.\n");
        showCheckOutBookOptions();
    }

    private void checkOutTheSelectedMovie(String movieName) {
        if(checkMovieProcessor.checkOutMovie(movieName)){
            System.out.println("Thank you! Enjoy the Movie.\n");
            showWelcomePage();
            return;
        }
        System.out.println("That Movie is not available.\n");
        showCheckOutMovieOptions();
    }

    private void returnTheSelectedBook(String bookId) {
        if(checkBookProcessor.returnBook(bookId)){
            System.out.println("Thank you for returning the book.\n");
            showWelcomePage();
            return;
        }

        System.out.println("That is not a valid book to return.\n");
        showReturnBookOptions();
    }

    private void returnTheSelectedMovie(String movieName) {
        if(checkMovieProcessor.returnMovie(movieName)){
            System.out.println("Thank you for returning the movie.\n");
            showWelcomePage();
            return;
        }

        System.out.println("That is not a valid movie to return.\n");
        showReturnBookOptions();
    }

    public void showErrorMessage() {
        System.out.println("Select a valid option!");
    }


    private void quit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        List<Book> availableBookList = new ArrayList(){{
            add(new Book("1", "Refactoring", "Martin Flower", 2012, State.CHECKED_IN));
            add(new Book("2", "TDD", "Kent Beck", 2003, State.CHECKED_IN));
        }};
        List<Book> checkedOutBookList = new ArrayList(){{
            add(new Book("3", "Thinking in Java", "Bruce Eckel", 2006, State.CHECKED_OUT));
        }};
        CheckBookProcessor checkBookProcessor = new CheckBookProcessor(availableBookList, checkedOutBookList);

        List<Movie> availableMovieList = new ArrayList(){{
            add(new Movie("hh", "2012", "Tom", MovieRating.SEVEN, State.CHECKED_IN));
        }};
        List<Movie> checkedOutMovieList = new ArrayList(){{
            add(new Movie("gg", "2009", "Jim", MovieRating.UN_RATED, State.CHECKED_OUT));
        }};
        CheckMovieProcessor checkMovieProcessor = new CheckMovieProcessor(availableMovieList, checkedOutMovieList);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(checkBookProcessor, checkMovieProcessor);
        bibliotecaApp.showWelcomePage();

    }
}
