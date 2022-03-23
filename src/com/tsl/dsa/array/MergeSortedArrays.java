package com.tsl.dsa.array;

/*
        Leet Code : 88. Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure
the merge result can fit in nums1.
 */

import java.util.Scanner;

public class MergeSortedArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MergeSortedArrays obj = new MergeSortedArrays();

        System.out.println("Enter length of Array 1 (m)");
        int m = scanner.nextInt();
        System.out.println("Enter length of Array 2 (n)");
        int n = scanner.nextInt();

        System.out.println("Enter " + m + " elements in Array 1 (SORTED)");
        int[] numbers1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            numbers1[i] = scanner.nextInt();
        }

        System.out.println("Enter " + n + " elements in Array 2 (SORTED)");
        int[] numbers2 = new int[n];
        for (int j = 0; j < n; j++) {
            numbers2[j] = scanner.nextInt();
        }

        obj.mergeSortedArrays(numbers1, m, numbers2, n);

        System.out.println("Final Merged Sorted Array is : ");
        for (int number : numbers1) {
            System.out.print(number + " ");
        }
    }

    private void mergeSortedArrays(int[] numbers1, int length1, int[] numbers2, int length2) {

        // Fix lengths to relate with indexes
        int currentIndex = length1 + length2 - 1;
        int index1 = length1-1; // As index start with 0 to length-1 of array
        int index2 = length2-1; // As index start with 0 to length-1 of array

        //Lengths are indexes now and Merge the Arrays from Reverse end.
        while (index1 >= 0 && index2 >= 0) {

            if (numbers1[index1] > numbers2[index2]) {
                numbers1[currentIndex] = numbers1[index1];
                index1--;
            } else {
                numbers1[currentIndex] = numbers2[index2];
                index2--;
            }
            currentIndex--;
        }

        while (index2 >= 0) {
            numbers1[currentIndex] = numbers2[index2];
            index2--;
        }


        // Method 2  : More Optimal  (Read & and && operators)
        /*
        while(index2 >=0){

            if(index1 >= 0 && numbers1[index1] > numbers2[index2]){
                numbers1[currentIndex] = numbers1[index1];
                index1--;
            }
            else{
                numbers1[currentIndex] = numbers2[index2];
                index2--;
            }
            currentIndex--;
        }
         */

    }

}
