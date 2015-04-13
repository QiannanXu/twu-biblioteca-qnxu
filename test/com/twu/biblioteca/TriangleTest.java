package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    private Triangle triangle;

    @Before
    public void init(){
        triangle = new Triangle();
    }

    @Test
    public void shouldPrintOneAsteriskToConsole(){
        assertEquals("*", triangle.printOneAsterisk());
    }

    @Test
    public void shouldPrintAHorizontalLineToConsole(){
        assertEquals("********", triangle.printAHorizontalLine(8));
    }

    @Test
    public void shouldPrintAVerticalLineToConsole(){
        assertEquals("*\n*\n*\n", triangle.printAVerticalLine(3));
    }

    @Test
    public void shouldDrawARightTriangle(){
        assertEquals("*\n**\n***\n", triangle.drawARightTriangle(3));
    }

    @Test
    public void shouldDrawIsoscelesTriangle(){
        assertEquals("  *\n ***\n*****\n", triangle.drawIsoscelesTriangle(3));
    }

    @Test
    public void shouldDrawCenteredDiamod(){
        assertEquals("  *\n ***\n*****\n ***\n  *\n", triangle.drawCenteredDiamond(3));
    }

    @Test
    public void shouldDrawCenteredDiamodWithName(){
        assertEquals("  *\n ***\nQiannanXu\n ***\n  *\n", triangle.drawCenteredDiamondWithName(3));
    }
}
