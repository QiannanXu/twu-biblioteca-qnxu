package com.twu.biblioteca;

import com.twu.biblioteca.processor.CheckBookProcessor;
import com.twu.biblioteca.processor.CheckMovieProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        CheckBookProcessor checkBookProcessor = mock(CheckBookProcessor.class);
        CheckMovieProcessor checkMovieProcessor = mock(CheckMovieProcessor.class);
        bibliotecaApp = new BibliotecaApp(checkBookProcessor, checkMovieProcessor);
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
                "4.List Movies\n" +
                "5.Check Out Movies\n" +
                "6.Return Movies\n" +
                "7.Quit\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowErrorMessage(){
        bibliotecaApp.showErrorMessage();
        assertEquals("Select a valid option!\n", outContent.toString());
    }

}
