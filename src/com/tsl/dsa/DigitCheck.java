package com.tsl.dsa;

import java.util.Scanner;

public class DigitCheck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a Number : ");
        long input = scanner.nextLong();
        int singleDigit, digitLength;

        do {
            System.out.println("Please Input a Single digit to Search :");
            singleDigit = scanner.nextInt();
            digitLength = Integer.toString(Math.abs(singleDigit)).trim().length();
        } while (digitLength != 1);

        int count = 0;

        while (input > 0) {
            int remainder = (int) (input % 10);

            if (remainder == singleDigit)
                count++;
            input = input / 10;
            //System.out.println("digit is "+input);
        }
        System.out.println(singleDigit + " occurred " + count + " times scanner the given number.");
    }
}
