package com.tsl.dsa.array;

import com.tsl.dsa.binarysearch.BinarySearchArray;

import java.util.Scanner;
 /*

    Ceiling Number of given target number in an Array.
    Ceiling Number means : Smallest number in array  >= Target Number

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 52;
    Ceiling is : 52

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 70;
    Ceiling is : 72

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 1;
    Ceiling is : 12

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 200;
    Ceiling is : NO Ceiling

*/

public class CeilingNumberInArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CeilingNumberInArray obj = new CeilingNumberInArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.print("Enter Numbers in Array (ASCENDING ORDER) : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter a Number to find Ceiling Of : ");
        int targetNo = scanner.nextInt();

        int ceilingNo = obj.ceilingNumber(numbers, targetNo);
        if(ceilingNo == -1)
            System.out.println("No Ceiling of "+ targetNo);
        else
            System.out.println("Ceiling of "+ targetNo + " is " + ceilingNo);

    }

    private int ceilingNumber(int[] numbers, int targetNo) {
        int startIndex = 0, endIndex = numbers.length -1;

        // Edge Case : Target number is greater than the Greatest element in Array
        if(targetNo > numbers[endIndex])
            return -1;

        while (startIndex <= endIndex){

            int midIndex = (startIndex + endIndex)/2;

            if(targetNo < numbers[midIndex])
                endIndex = midIndex -1;
            else if(targetNo > numbers[midIndex])
                startIndex = midIndex +1;
            else
                return numbers[midIndex];
        }
        return numbers[startIndex];
    }
}
