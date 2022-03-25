package com.tsl.dsa.array;

import java.util.Arrays;
import java.util.Scanner;

/*
    LeetCode : 2148. Count Elements With Strictly Smaller and Greater Elements

    Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly
    greater element appear in nums.

Example 1:
Input: nums = [11,7,2,15]
Output: 2
Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.

Example 2:
Input: nums = [-3,3,3,90]
Output: 2
Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.
Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller
and a strictly greater element appear in nums.

        NOTES:
        Option 1
        First, find the MIN and MAX in the Array, and then check for each element check if it is between min and
        max increment the count.


 */
public class CountElementsWithSmallerAndGreaterElementsInArray
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountElementsWithSmallerAndGreaterElementsInArray obj = new
                CountElementsWithSmallerAndGreaterElementsInArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] digits = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < digits.length; i++){
            digits[i] = scanner.nextInt();
        }
        int result = obj.countElements(digits);
        System.out.println(" Count is :"+ result);
    }

    private int countElements(int[] nums) {

        int count=0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int j : nums) {
            if (j < minValue)
                minValue = j;
            if (j > maxValue)
                maxValue = j;
        }
        for (int num : nums) {
            if (num > minValue && num < maxValue)
                count++;
        }
        return count;
    }
}
