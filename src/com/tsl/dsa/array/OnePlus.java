package com.tsl.dsa.array;

import java.util.Arrays;
import java.util.Scanner;

/*
        Leet Code : 66. Plus One
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the
integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer
does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

 */
public class OnePlus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnePlus onePlus = new OnePlus();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] digits = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < digits.length; i++){
            digits[i] = scanner.nextInt();
        }

        int[] result = onePlus.getOnePlus(digits);
        System.out.println(" One Plus of given Array is :"+ Arrays.toString(result));
    }

    private int[] getOnePlus(int[] digits){

        // Basically add one to the last digit of the Array
        // So, start from the last element

        for(int cnt = digits.length-1; cnt >= 0; cnt--){

            // for normal case : where number is less than 9 just add 1 and return the array
            if(digits[cnt] < 9){
                digits[cnt]++;
                return digits;
            }
            // if the element is 9 make it to 0
            digits[cnt] = 0;
        }
        //if all are 9, we need to add one more digit at start and return new array
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
