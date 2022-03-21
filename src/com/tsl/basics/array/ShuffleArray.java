package com.tsl.basics.array;

import java.util.Arrays;
import java.util.Scanner;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]

 */
public class ShuffleArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShuffleArray obj = new ShuffleArray();

        System.out.print("Enter value for 'n' : ");
        int n = scanner.nextInt();
        int[] numbers = new int[2 * n];  // size of array if 2n
        System.out.print("Enter "+ (2 * n) +" Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }

        int[] result = obj.shuffleArray1(numbers,n);
        System.out.println("Shuffled Array is : "+ Arrays.toString(result));
    }

    private int[] shuffleArray(int[] numbers, int n) {

        int cnt = 0, cnt1 = 0, cnt2 = n;
        int [] newNumbers = new int[2 * n];

        while(cnt < 2*n){
            newNumbers[cnt]=numbers[cnt1];
            newNumbers[cnt+1]=numbers[cnt2];
            cnt=cnt+2;
            cnt1++;
            cnt2++;
        }
        return newNumbers;
    }

    // better way
    private int[] shuffleArray1(int[] numbers, int n) {

        int cnt1=0, cnt2=n;
        while(cnt1 < n){

            if(cnt1 % 2 != 0){
                int temp = numbers[cnt1];
                numbers[cnt1] = numbers[cnt2];
                numbers[cnt2] = temp;
            }
            cnt1=cnt1+1;
            cnt2 = cnt2+1;
        }
        return numbers;
    }
}
