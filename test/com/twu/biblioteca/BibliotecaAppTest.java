package com.twu.biblioteca;

import com.sun.javaws.exceptions.ExitException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        bibliotecaApp = new BibliotecaApp();
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
                "3.Quit\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowBookListAfterShowingWelcomeMessage(){
        bibliotecaApp.showBookList();
        assertEquals("Here is the book list:\n" +
                "---------------------------------------------\n" +
                "Id   Name                Author              Year                \n" +
                "---------------------------------------------\n" +
                "1    Refactoring         Martin Flower       2012                \n" +
                "2    TDD                 Kent Beck           2003                \n" +
                "3    Thinking in Java    Bruce Eckel         2006                \n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowMainMenu(){
        bibliotecaApp.showSelectMenuOptions();

        assertEquals("Please Select an Option:\n" +
                "---------------------------------------------\n" +
                "1.List Books\n" +
                "2.Check Out Books\n" +
                "3.Quit\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowErrorMessage(){
        bibliotecaApp.showErroMessage();
        assertEquals("Select a valid option!\n", outContent.toString());
    }
}
