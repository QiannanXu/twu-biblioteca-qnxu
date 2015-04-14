package com.twu.biblioteca.introductory;

public class FizzBuzz {

    public String print(int i) {
        if(i%3 == 0 && i%5 != 0){
            return "Fizz";
        }
        if(i%3 != 0 && i%5 == 0){
            return "Buzz";
        }
        if(i%3 == 0 && i%5 == 0){
            return "FizzBuzz";
        }
        return Integer.toString(i);
    }

    public String printNNumber(int n) {
        String outputMessage = "";
        for(int i=0; i<n; i++){
            outputMessage += print(i+1) + "\n";
        }
        return outputMessage;
    }
}
