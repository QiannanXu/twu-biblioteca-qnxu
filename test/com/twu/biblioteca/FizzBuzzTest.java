package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void shouldPrintOneWhenNumberIsOne(){
        assertEquals("1", new FizzBuzz().print());
    }
}
