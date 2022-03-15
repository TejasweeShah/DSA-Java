package com.tsl.basics;

import java.util.Scanner;

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
        int no1 = 0, no2 = 1, count = 1;

        while (count != nthNo) {
            int tempSum = no1 + no2;
            no1 = no2;
            no2 = tempSum;
            count++;
        }

        System.out.println(nthNo + "th Number in Fibonacci Series is : " + no1);
    }
}
