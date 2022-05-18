package com.codewithteju.dsa.array;

import java.util.Arrays;
import java.util.Scanner;

/*
        LeetCode : 34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a
given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

        MY NOTES :
        Brut Force Approach : to have two pointers at first and last of Array and traverse to find the respective
        positions where target == the no in array.
        But, that's not O(log n)

        Another option : AS it's a sorted Array, use BinarySearch to find the target number.
        To find the first position of the number, continue BS on first half of the number till you find the
        no(mid) == target. Same goes for the last position in the 2nd half of the array.

 */
public class FirstAndLastPositionOfANumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FirstAndLastPositionOfANumber obj = new
                FirstAndLastPositionOfANumber();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter Numbers to Look For : ");
        int searchNo = scanner.nextInt();

        int[] positions = obj.searchRange(numbers,searchNo);
        System.out.println(" First & LAst Position of the "+searchNo+" is :"+ Arrays.toString(positions));
    }

    private int[] searchRange(int[]numbers, int searchNo){

        /*
        int firstPosition = binarySearch(numbers,searchNo,true);
        int lastPosition = binarySearch(numbers,searchNo,false);
        return new int[]{firstPosition,lastPosition};
         */

        int[] positions = {-1,-1};
        positions[0] = binarySearch(numbers,searchNo,true);
        if (positions[0] != -1)      // Find the last occurrence only if the first is found
            positions[1] = binarySearch(numbers,searchNo,false);
        return positions;

    }

    private int binarySearch(int[]numbers, int searchNo, boolean lookingForFirstOccurance){
        int foundAt = -1;
        int startIndex = 0, endIndex= numbers.length-1;

        while(startIndex <= endIndex){

            int midIndex = (startIndex + endIndex) / 2;

            if(searchNo < numbers[midIndex]){
                   endIndex = midIndex - 1;
            }else if( searchNo > numbers[midIndex]){
                startIndex = midIndex + 1;
            }else {
                //searchNo == numbers[midIndex]
                foundAt = midIndex;
                // Don't return the midIndex position, rather check if that is the final first or last occurrence
                // in either of the arrays
                // so, keep on doing the BS tll the end of each side
                if(lookingForFirstOccurance){
                    endIndex = midIndex -1;
                }
                else{
                    startIndex = startIndex + 1;
                }
            }
        }
        return foundAt;
    }
}
