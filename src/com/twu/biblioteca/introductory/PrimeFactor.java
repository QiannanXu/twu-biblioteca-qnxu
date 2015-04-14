package com.twu.biblioteca.introductory;

public class PrimeFactor {

    public void generate(int input) {
        if(input == 1){
            return;
        }
        for (int i = 2; i <= input; i++) {
            if (input % i == 0) {
                System.out.print(i + " ");
                generate(input / i);
                break;
            }
        }
    }
}
