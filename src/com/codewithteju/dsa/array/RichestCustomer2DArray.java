package com.codewithteju.dsa.array;

/*
        Leet Code : 1672 Richest Customer Wealth
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the
ith customer has in the jth bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer
that has the maximum wealth.

Example 1:
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.

Example 2:
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:
Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
 */

import java.util.Scanner;

public class RichestCustomer2DArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RichestCustomer2DArray obj = new RichestCustomer2DArray();

        System.out.print("Enter No of rows in Matrix : ");
        int rows = scanner.nextInt();
        System.out.print("Enter No of Columns in each Row : ");
        int columns = scanner.nextInt();

        System.out.print("Enter elements for Matrix [" + rows + "][" + columns + "] :");
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int result = obj.getMaxWealth(matrix);
        System.out.println("Richest Customer has max Wealth : " + result);
    }

    private int getMaxWealth(int[][] accounts) {
        int maxWealth = 0, currentWealth;

        for (int[] account : accounts) {
            currentWealth = 0;
            for (int wealth : account) {
                currentWealth = currentWealth + wealth;
            }

            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }

}
