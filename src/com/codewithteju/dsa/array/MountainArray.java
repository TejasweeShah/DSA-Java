package com.codewithteju.dsa.array;

import java.util.Scanner;

/*
        Leet Code : 941 Valid Mountain Array
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
Constraints:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

*/

public class MountainArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MountainArray mountainArray = new MountainArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }

        if(mountainArray.isMountainArray(numbers))
            System.out.println("IS Mountain Array.");
        else
            System.out.println("IS NOT a Mountain Array.");
    }

    private boolean isMountainArray(int[] numbers) {

        if(numbers.length < 3)
            return false;

        int cnt = 0;

        // check for strict Increasing
        while(cnt < numbers.length && cnt+1 < numbers.length && numbers[cnt] < numbers[cnt+1])
            cnt++;

        // edge case :  if only increasing array (cnt reached at end) , so is not a mountain array
        // edge case : if only decreasing array return false (cnt is at 0 only) , so is not a mountain array
        if(cnt == 0 || cnt+1 >= numbers.length )
            return  false;

        while(cnt < numbers.length && cnt+1 < numbers.length){
            //if anytime trend changes, not a mountain array
            if (numbers[cnt] <= numbers[cnt+1])
                return false;
            cnt++;
        }
        return true;
    }
}
