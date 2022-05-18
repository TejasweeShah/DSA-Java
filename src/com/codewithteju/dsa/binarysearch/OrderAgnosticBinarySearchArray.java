package com.codewithteju.dsa.binarysearch;

import java.util.Scanner;

/*
   Binary Search : Search for a number in given SORTED array using Binary Search Algorithm
   Order Agnostic Binary Search Program  means if the Order(Ascending or Descending) of the sorted Array is not Known.
 */

public class OrderAgnosticBinarySearchArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrderAgnosticBinarySearchArray obj = new OrderAgnosticBinarySearchArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.print("Enter Numbers in Array (SORTED): ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter a Number to Look for : ");
        int searchNo = scanner.nextInt();

        int position = obj.binarySearch(numbers,searchNo);

        if(position == -1)
            System.out.println(searchNo + " NOT FOUND.");
        else
            System.out.println(searchNo + " FOUND AT "+ position + " position.");
    }

    private int binarySearch(int[] numbers, int searchNo) {
        int startIndex = 0, endIndex = numbers.length-1;

        // Check Array is Ascending OR Descending
        boolean isAscending = numbers[startIndex] < numbers[endIndex];

        while(startIndex <= endIndex){

            int midIndex = (startIndex + endIndex) / 2;

            // Edge Case : (start + end) can exceed the  Int range for bigger arrays.
            // So the better way to find mid is
            //int midIndex = startIndex + (endIndex - startIndex) / 2;

            // best case common in both cases
            //searchNo == numbers[midIndex] So, number FOUND, return position
            if(searchNo == numbers[midIndex])
                return midIndex;

            if(isAscending){

                if(searchNo < numbers[midIndex])
                    endIndex = midIndex -1;
                else if(searchNo > numbers[midIndex])
                    startIndex = midIndex + 1;
            }else
            {
                if(searchNo > numbers[midIndex])
                    endIndex = midIndex -1;
                else if (searchNo < numbers[midIndex])
                    startIndex = midIndex + 1;
            }
        }
        return -1;  // Number NOT FOUND, return position as -1
    }
}
