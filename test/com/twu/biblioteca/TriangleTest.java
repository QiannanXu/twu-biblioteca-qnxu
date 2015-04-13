package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void shouldPrintOneAsteriskToConsole(){
        assertEquals("*", new Triangle().printOneAsterisk());
    }

    @Test
    public void shouldPrintAHorizontalLineToConsole(){
        assertEquals("********", new Triangle().printAHorizontalLine(8));
    }

    @Test
    public void shouldPrintAVerticalLineToConsole(){
        assertEquals("*\n*\n*\n", new Triangle().printAVerticalLine(3));
    }
}
