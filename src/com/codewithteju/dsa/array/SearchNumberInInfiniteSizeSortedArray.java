package com.codewithteju.dsa.array;

import java.util.Scanner;

/*
    Problem Statement : Find the position of an Element in a Sorted Array of Infinite size
    https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
    Source: Amazon Interview Experience.
    Since array is sorted, the first thing clicks into mind is binary search,
    but the problem here is that we don’t know size of array.
    If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find
    position of key, first we find bounds and then apply binary search algorithm.

    Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
    ->if it is greater than high index element then copy high index in low index and double the high index.
    ->if it is smaller, then apply binary search on high and low indices found.
 */

public class SearchNumberInInfiniteSizeSortedArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SearchNumberInInfiniteSizeSortedArray obj = new
                SearchNumberInInfiniteSizeSortedArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter Number to Look For : ");
        int searchNo = scanner.nextInt();

        int position = obj.searchNumber(numbers, searchNo);
        System.out.println(" Number found at Position " + position);

    }

    private int searchNumber(int[] numbers, int searchNo) {
        // Get the array in chunks
        int startIndex = 0;
        int endIndex = 1;

        // Condition to search for an element in the array is : it should be less than
        // the last element of the current chunk
        while (searchNo > numbers[endIndex]) {

            //Change the range to next set of numbers by updating the indices
            int newStart = endIndex + 1;
            // Double the  chunk size : new end is last end + size of the previous chunk * 2;
            //endIndex = endIndex + (endIndex - startIndex + 1) * 2; (This can work in real scenario with infinite array
            // and size of array increasing 2n times every check.
            // But with limited array size, this can create ArrayIndexOutOfBound
            endIndex = endIndex * 2;
            startIndex = newStart;
        }
        // so we finally got he endIndex of the array
        // Now BS on the newStartIndex and endIndex
        return binarySearch(numbers, startIndex, endIndex, searchNo);
    }

    private int binarySearch(int[] numbers, int startIndex, int endIndex, int searchNo) {

        while (startIndex <= endIndex) {

            //int midIndex = (startIndex + endIndex) / 2;
            // Edge Case : (start + end) can exceed the  Int range for bigger arrays.
            // So the better way to find mid is
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (searchNo < numbers[midIndex])
                endIndex = midIndex - 1;
            else if (searchNo > numbers[midIndex])
                startIndex = midIndex + 1;
            else
                //searchNo == numbers[midIndex] So, number FOUND, return position
                return midIndex;
        }
        return -1;  // Number NOT FOUND, return position as -1
    }
}
