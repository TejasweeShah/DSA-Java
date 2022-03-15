package com.tsl.basics;

import java.util.Scanner;

/*
*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.
*
* */

public class Palindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Number :");
        int originalNo = scanner.nextInt();

        Palindrome palindromeObj = new Palindrome();
        if (palindromeObj.isPalindrome(originalNo)) {
            System.out.println(originalNo + "is a Palindrome Number");
        } else {
            System.out.println(originalNo + "is NOT a Palindrome Number");
        }
    }

    private boolean isPalindrome(int number) {

        int originalNo = number, reverseNo = 0, remainder;

        // edge case : Negative Number
        if (number < 0) {
            return false;
        }

        // get the reverse Number
        while (originalNo != 0) {

            remainder = originalNo % 10;
            reverseNo = reverseNo * 10 + remainder;
            originalNo /= 10;
        }

        // Compare 2 nos to check Palindrome or Not
        return number == reverseNo;
    }
}
