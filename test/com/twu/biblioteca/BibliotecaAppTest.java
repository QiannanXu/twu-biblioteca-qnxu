package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertEquals("Welcome to Biblioteca Library!\n", outContent.toString());
    }

    @Test
    public void shouldShowBookListAfterShowingWelcomeMessage(){
        bibliotecaApp.showBookList();
        assertEquals("Here is the book list:\nRefactoring\nTDD\nThinking in Java\n", outContent.toString());
    }
}
