package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputScannerTest {
    private InputScanner inputScanner;

    @Before
    public void init(){
        inputScanner = mock(InputScanner.class);
    }

    @Test
    public void shouldReturnCorrectInputMessage(){
        when(inputScanner.scanner("Please Input UserName:")).thenReturn("123-1234");
        when(inputScanner.scanner("Please Input Password:")).thenReturn("123456");
    }
}
