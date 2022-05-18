package com.codewithteju.dsa.array;

import java.util.Scanner;
 /*

    Floor Number of given target number in an Array.
    Floor Number means : Largest Number in the array <= Target Number

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 42;
    Ceiling is : 42

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 40;
    Ceiling is : 32

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 102;
    Ceiling is : 92

    Example :
    int[] numbers = {12,22,32,42,52,62,72,82,92,102};
    int targetNo = 12;
    Ceiling is : NO Floor

*/

public class FloorNumberInArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FloorNumberInArray obj = new FloorNumberInArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.print("Enter Numbers in Array (ASCENDING ORDER) : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter a Number to find Ceiling Of : ");
        int targetNo = scanner.nextInt();

        int ceilingNo = obj.floorNumber(numbers, targetNo);
        if(ceilingNo == -1)
            System.out.println("No FLOOR of "+ targetNo);
        else
            System.out.println("FLOOR of "+ targetNo + " is " + ceilingNo);

    }

    private int floorNumber(int[] numbers, int targetNo) {
        int startIndex = 0, endIndex = numbers.length -1;

        // Edge Case : Target number is smaller than the Smallest element in Array
        if(targetNo < numbers[startIndex])
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
        return numbers[endIndex];
    }
}
