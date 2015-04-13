package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void shouldPrintOneWhenNumberIsOne(){
        assertEquals("1", new FizzBuzz().print(1));
    }

    @Test
    public void shouldPrintTwoWhenNumberIsTwo(){
        assertEquals("2", new FizzBuzz().print(2));
    }

    @Test
    public void shouldPrintFizzWhenNumberIsThree() {
        assertEquals("Fizz", new FizzBuzz().print(3));
    }

    @Test
    public void shouldPrintBuzzWhenNumberIsFive(){
        assertEquals("Buzz", new FizzBuzz().print(5));
    }

    @Test
    public void shouldPrintFizzBuzzWhenNumberIsFifteen(){
        assertEquals("FizzBuzz", new FizzBuzz().print(15));
    }

    @Test
    public void shouldPrintCorrentMessageForNumberRange(){
        assertEquals("1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n", new FizzBuzz().printNNumber(15));
    }
}
