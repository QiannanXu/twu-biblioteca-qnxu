package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {
    private PrimeFactor primeFactor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        primeFactor = new PrimeFactor();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldReturnNullWhenNumberEqualsOne(){
        primeFactor.generate(1);
        assertEquals("",  outContent.toString());
    }

    @Test
    public void shouldReturnTwoWhenNumberEqualsTwo(){
        primeFactor.generate(2);
        assertEquals("2 ",  outContent.toString());
    }

    @Test
    public void shouldReturnFactorWhenNumberEqualsThirty(){
        primeFactor.generate(60);
        assertEquals("2 2 3 5 ",  outContent.toString());
    }
}
