package com.twu.biblioteca.processor;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.MovieRating;
import com.twu.biblioteca.entity.State;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckMovieProcessorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private CheckMovieProcessor checkMovieProcessor;

    @Before
    public void init(){
        System.setOut(new PrintStream(outContent));
        List<Movie> availableMovieList = new ArrayList(){{
            add(new Movie("hh", "2012", "Tom", MovieRating.SEVEN, State.CHECKED_IN));
        }};
        List<Movie> checkedOutMovieList = new ArrayList(){{
            add(new Movie("gg", "2009", "Jim", MovieRating.UN_RATED, State.CHECKED_OUT));
        }};
        checkMovieProcessor = new CheckMovieProcessor(availableMovieList, checkedOutMovieList);
    }

    @Test
    public void shouldShowAvailableMovieList(){
        checkMovieProcessor.showAvailableMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "hh   2012                Tom                 SEVEN               \n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowCheckedOutMovieList(){
        checkMovieProcessor.showCheckedOutMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "gg   2009                Jim                 UN_RATED            \n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldNotShowWhenMovieIsCheckedOut(){
        checkMovieProcessor.checkOutMovie("hh");
        checkMovieProcessor.showAvailableMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowInCheckedOutListWhenMovieIsCheckedOut(){
        checkMovieProcessor.checkOutMovie("hh");
        checkMovieProcessor.showCheckedOutMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "gg   2009                Jim                 UN_RATED            \n" +
                "hh   2012                Tom                 SEVEN               \n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldNotShowInCheckedOutListWhenMovieIsReturned(){
        checkMovieProcessor.returnMovie("gg");
        checkMovieProcessor.showCheckedOutMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "---------------------------------------------\n", outContent.toString());
    }

    @Test
    public void shouldShowInAvailableListWhenMovieIsReturned(){
        checkMovieProcessor.returnMovie("gg");
        checkMovieProcessor.showAvailableMovieList();
        assertEquals("Here is the Movie list:\n" +
                "---------------------------------------------\n" +
                "Name Year                Director            Rating              \n" +
                "---------------------------------------------\n" +
                "hh   2012                Tom                 SEVEN               \n" +
                "gg   2009                Jim                 UN_RATED            \n" +
                "---------------------------------------------\n", outContent.toString());
    }
}
