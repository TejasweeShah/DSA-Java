package com.codewithteju.dsa.array;

/*
        Leet Code : 1295. Find Numbers with Even Number of Digits
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.
 */


import java.util.Scanner;

public class EvenNoOfDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EvenNoOfDigits obj = new EvenNoOfDigits();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter " + size + " Numbers in an Array : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int result = obj.findNumbersWithEvenDigits(numbers);
        System.out.println(" Final Count :" + result);
    }

    private int findNumbersWithEvenDigits(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            int noOFDigits = 0;

            if (number < 0)
                number = number * -1;

            if (number == 0)
                noOFDigits++;

            while (number > 0) {
                noOFDigits++;
                number = number / 10;
            }
            System.out.println("Digits :" + noOFDigits);

            if (noOFDigits % 2 == 0)
                count++;

            System.out.println("Count :" + count);
        }
        return count;
    }

}
