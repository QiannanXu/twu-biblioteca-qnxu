package com.twu.biblioteca;

public class Triangle {

    public String printOneAsterisk() {
        return "*";
    }

    public String printAHorizontalLine(int n) {
        String asteriskMessage = "";
        for(int i = 0; i < n; i++){
            asteriskMessage += "*";
        }
        return asteriskMessage;
    }

    public String printNBlank(int n) {
        String blankMessage = "";
        for(int i = 0; i < n; i++){
            blankMessage += " ";
        }
        return blankMessage;
    }

    public String printAVerticalLine(int rowNum) {
        String outputMessage = "";
        for(int i = 0; i < rowNum; i++){
            outputMessage += "*\n";
        }
        return outputMessage;
    }

    public String drawARightTriangle(int n) {
        String outputMessage = "";
        for(int i = 0; i < n; i++){
            outputMessage += printAHorizontalLine(i + 1) + "\n";
        }
        return outputMessage;
    }

    public String drawIsoscelesTriangle(int n) {
        String outputMessage = "";
        for(int i = 0; i < n; i++){
            outputMessage += printNBlank(n-i-1) + printAHorizontalLine(2*i+1) + "\n";
        }
        return outputMessage;
    }

    private String drawReverseIsoscelesTriangle(int n) {
        String outputMessage = "";
        for(int i = n-1; i >= 0; i--){
            outputMessage += printNBlank(n-i) + printAHorizontalLine(2*i+1) + "\n";
        }
        return outputMessage;
    }

    public String drawCenteredDiamond(int n) {
        return drawIsoscelesTriangle(n) + drawReverseIsoscelesTriangle(n-1);
    }

    public String drawCenteredDiamondWithName(int n) {
        return drawIsoscelesTriangleWithName(n) + drawReverseIsoscelesTriangle(n-1);
    }

    private String drawIsoscelesTriangleWithName(int n) {
        String outputMessage = "";
        for(int i = 0; i < n-1; i++){
            outputMessage += printNBlank(n-i-1) + printAHorizontalLine(2*i+1) + "\n";
        }
        return outputMessage + "QiannanXu\n";
    }
}