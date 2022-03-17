package com.tsl.basics.array;

/*
 An array is monotonic if it is either monotone increasing or monotone decreasing.
 An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if
 for all i <= j, nums[i] >= nums[j].
 Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 Example 1:
Input: nums = [1,2,2,3]
Output: true

Example 2:
Input: nums = [6,5,4,4]
Output: true

Example 3:
Input: nums = [1,3,2]
Output: false
 */


import java.util.Scanner;

public class MonotonicArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MonotonicArray monotonicArray = new MonotonicArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        int j=0;
        for (int number : numbers){
            numbers[j++] = scanner.nextInt();
        }

        if(monotonicArray.isMonotone(numbers))
            System.out.println("Array is Monotonic.");
        else
            System.out.println("Array is NOT Monotonic.");
    }

    private boolean isMonotone(int[] numbers){
        boolean increasing = true, decreasing = true;

        for (int i=0 ; i < numbers.length-1 ; i++){
            if(numbers[i] > numbers[i+1])
                increasing = false;

            if(numbers[i] < numbers[i+1])
                decreasing = false;
        }
        return increasing || decreasing;
    }
}
