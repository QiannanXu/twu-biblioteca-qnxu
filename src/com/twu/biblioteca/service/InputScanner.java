package com.twu.biblioteca.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputScanner {
    private final Scanner scanner;
    private final PrintStream out;

    public InputScanner(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String scanner(String message) {
        out.println(message);
        return scanner.next();
    }
}
