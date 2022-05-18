package com.codewithteju.dsa;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Digit");
        long inputNo = input.nextLong();
        long reverse = 0;

        while (inputNo > 0) {
            int digit = (int) inputNo % 10;
            reverse = reverse * 10 + digit;

            inputNo = inputNo / 10;
        }

        System.out.println("Reverse Number is : " + reverse);
    }

}
