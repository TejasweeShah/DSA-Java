package com.codewithteju.dsa;

import java.util.Scanner;

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

 */

public class Fibonacci {

    public static void main(String[] args) {

        int option;
        Fibonacci fiboObj = new Fibonacci();
        do {
            System.out.println("\n 1. Print Series \n 2. Print nth Fibonacci Number \n 3. Exit");
            System.out.print("Select one option ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Length of Series : ");
                    int seriesLength = scanner.nextInt();
                    fiboObj.printSeries(seriesLength);
                }
                case 2 -> {
                    System.out.print("Enter nth number : ");
                    int nthNo = scanner.nextInt();
                    fiboObj.printNthNo(nthNo);
                }
                default -> System.out.println("Please Enter Correct Option");
            }

        } while (option != 3);
    }

    private void printSeries(int seriesLength) {
        int no1 = 0, no2 = 1, count = 0;

        System.out.print("Fibonacci Series is : ");
        while (count < seriesLength) {
            System.out.print(no1 + " ");

            int tempSum = no1 + no2;
            no1 = no2;
            no2 = tempSum;
            count++;
        }
    }

    private void printNthNo(int nthNo) {
        int no1 = 0, no2 = 1, count = 0;

        while (count < nthNo) {
            int tempSum = no1 + no2;
            no1 = no2;
            no2 = tempSum;
            count++;
        }

        System.out.println(nthNo + "th Number in Fibonacci Series is : " + no1);
    }
}
