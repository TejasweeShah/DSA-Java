package com.tsl.dsa.array;

import java.util.Scanner;

/*
    LeetCode : 852. Peak Index in a Mountain Array
    ALSO ::: 162. Find Peak Element has same solution

    Let's call an array arr a mountain if the following properties hold:
    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
    arr[0] < arr[1] < ... arr[i-1] < arr[i]
    arr[i] > arr[i+1] > ... > arr[arr.length - 1]

    Given an integer array arr that is guaranteed to be a mountain, return any i such that
    arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

    Example 1:
    Input: arr = [0,1,0]
    Output: 1

    Example 2:
    Input: arr = [0,2,1,0]
    Output: 1

    Example 3:
    Input: arr = [0,10,5,2]
    Output: 1

 */

public class PeakOfMountainArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PeakOfMountainArray obj = new PeakOfMountainArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int position = obj.findPeakOfMountain(numbers);
        System.out.println("Peak of given Mountain Array at Index : " + position);
    }

    private int findPeakOfMountain(int[] numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while (startIndex < endIndex) {

            int midIndex = (startIndex + endIndex) / 2;

            if (numbers[midIndex] < numbers[midIndex + 1]) {
                // left side is increasing(its highest number in first part), so check in 2nd half
                startIndex = midIndex + 1;
            } else if (numbers[midIndex] > numbers[midIndex + 1]) {
                //right side is decreasing(its highest number in second part), so check in 1st part
                endIndex = midIndex;
            }
        }
        //Finally startIndex == endIndex and then it's the highest from both the sides of the array.
        return startIndex;
    }
}
