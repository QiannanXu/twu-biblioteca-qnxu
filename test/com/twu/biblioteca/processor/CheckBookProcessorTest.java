package com.twu.biblioteca.processor;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookState;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckBookProcessorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CheckBookProcessor checkBookProcessor;

    @Before
    public void init(){
        System.setOut(new PrintStream(outContent));
        List<Book> availableBookList = new ArrayList(){{
            add(new Book("1", "Refactoring", "Martin Flower", 2012, BookState.CHECKED_IN));
            add(new Book("2", "TDD", "Kent Beck", 2003, BookState.CHECKED_IN));
        }};
        List<Book> checkedOutBookList = new ArrayList(){{
            add(new Book("3", "Thinking in Java", "Bruce Eckel", 2006, BookState.CHECKED_OUT));
        }};
        checkBookProcessor = new CheckBookProcessor(availableBookList, checkedOutBookList);
    }

    @Test
    public void shouldShowAvailableBookList(){
        checkBookProcessor.showAvailableBookList();
        assertEquals("Here is the book list:\n" +
                "---------------------------------------------\n" +
                "Id   Name                Author              Year                \n" +
                "---------------------------------------------\n" +
                "1    Refactoring         Martin Flower       2012                \n" +
                "2    TDD                 Kent Beck           2003                \n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowCheckedOutBookList(){
        checkBookProcessor.showCheckedOutBookList();
        assertEquals("Here is the book list:\n" +
                "---------------------------------------------\n" +
                "Id   Name                Author              Year                \n" +
                "---------------------------------------------\n" +
                "3    Thinking in Java    Bruce Eckel         2006                \n" +
                "---------------------------------------------\n", outContent.toString());

    }
}
