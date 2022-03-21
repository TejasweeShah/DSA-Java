package com.tsl.basics.searching;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch2DArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinearSearch2DArray obj = new LinearSearch2DArray();

        System.out.print("Enter No of rows in Matrix : ");
        int rows = scanner.nextInt();
        System.out.print("Enter No of Columns in each Row : ");
        int columns = scanner.nextInt();

        System.out.print("Enter elements for Matrix ["+rows+"]["+columns+"] :");
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        System.out.print("Enter number to Search : ");
        int noToSearch = scanner.nextInt();

        int[] position = obj.searchIn2D(matrix, noToSearch);
        if(position[0] == -1)
            System.out.println("NOT Found");
        else
            System.out.println("Found at "+ Arrays.toString(position));

        System.out.println("MAX no in 2D Matrix is "+obj.searchMaxIn2D(matrix));

    }


    int[] searchIn2D(int[][] matrix, int noToSearch){
        for (int row =0; row < matrix.length;row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == noToSearch)
                    return new int[]{row,col};
            }
        }
        return new int[]{-1,-1};
    }

    int searchMaxIn2D(int[][] matrix){
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int col : row) {
                if (col > max)
                    max = col;
            }
        }
        return max;
    }

}
