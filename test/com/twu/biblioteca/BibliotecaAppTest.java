package com.twu.biblioteca;

import com.twu.biblioteca.processor.CheckBookProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp bibliotecaApp;
    private CheckBookProcessor checkBookProcessor;
    private List<Book> availableBookList;
    private List<Book> checkedOutBookList;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

        availableBookList = new ArrayList(){{
            add(new Book("1", "Refactoring", "Martin Flower", 2012, BookState.CHECKED_IN));
            add(new Book("2", "TDD", "Kent Beck", 2003, BookState.CHECKED_IN));
            add(new Book("3", "Thinking in Java", "Bruce Eckel", 2006, BookState.CHECKED_IN));
        }};

        checkedOutBookList = new ArrayList<>();
        checkBookProcessor = new CheckBookProcessor(availableBookList, checkedOutBookList);
        bibliotecaApp = new BibliotecaApp(checkBookProcessor);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldShowWelcomePageWhenUserStartApplication(){
        bibliotecaApp.showWelcomePage();
        assertEquals("Welcome to Biblioteca Library!\n" +
                "\n" +
                "Please Select an Option:\n" +
                "---------------------------------------------\n" +
                "1.List Books\n" +
                "2.Check Out Books\n" +
                "3.Return Books\n" +
                "4.Quit\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowErrorMessage(){
        bibliotecaApp.showErroMessage();
        assertEquals("Select a valid option!\n", outContent.toString());
    }

}
