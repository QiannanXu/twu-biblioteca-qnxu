package com.twu.biblioteca;

public class Triangle {

    public String printOneAsterisk() {
        return "*";
    }

    public String printAHorizontalLine(int columnNum) {
        String outputMessage = "";
        for(int i = 0; i < columnNum; i++){
            outputMessage += "*";
        }
        return outputMessage;
    }

    public String printAVerticalLine(int rowNum) {
        String outputMessage = "";
        for(int i = 0; i < rowNum; i++){
            outputMessage += "*\n";
        }
        return outputMessage;
    }
}