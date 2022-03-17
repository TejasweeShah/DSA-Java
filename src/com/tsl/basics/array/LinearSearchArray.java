package com.tsl.basics.array;

/*
Linear Search : Search for a number in given array.
 */
import java.util.Scanner;

public class LinearSearchArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearSearchArray obj = new LinearSearchArray();

        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.print("Enter Numbers in Array : ");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.print("Enter an Element to Look for : ");
        int searchNo = scanner.nextInt();

        int position = obj.linerSearch(numbers,searchNo);
        if(position == -1)
            System.out.println(searchNo + " NOT FOUND.");
        else
            System.out.println(searchNo + " FOUND AT "+ position + " position.");
    }

    private int linerSearch(int[] numbers, int searchNo) {

        for(int cnt = 0; cnt < numbers.length; cnt++){
            if(numbers[cnt] == searchNo)
                return cnt;
        }
        return -1;
    }
}
