package com.tsl.dsa.array;

 /*         Leet Code : 744. Find the Smallest Letter Greater Than Target

    Ceiling Element means : Smallest element in array  > Target element
    Given a characters array letters that is sorted in non-decreasing order and a character target,
    return the smallest character in the array that is larger than target.

    Note that the letters wrap around.
    For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'


    NOTES ::
    1. Given condition that the letters are wrapped means if the element is last or any letter after that
    we should return first letter in array.
    So, at end of function instead of returning letters[startIndex] we return letters[startIndex% letters.length]
    for example = array length is 7, from 0 to 6 index we get 1%7=7, 3%7=3.... and for last index or
    if index exceeds the array length 7%7=0 and the array is wrapped to point at first letter.

    2. Given * the smallest character in the array that is larger than target *
    we remove the last comparison condition to return midIndex if the target == letters[midIndex] from the

*/

public class CeilingLetterInArray {

    public static void main(String[] args) {

        CeilingLetterInArray obj = new CeilingLetterInArray();

        char[] letters = {'c','d','e','h','l','m','p','s','t','w'};
        char target = 'a';

        char smallestChar = obj.ceilingCharter(letters, target);
        System.out.println("Smallest Letter in the Array Larger than "+ target + " is " + smallestChar);

    }

    private char ceilingCharter(char[] letters, char target) {
        int startIndex = 0, endIndex = letters.length -1;

        while (startIndex <= endIndex){

            int midIndex = (startIndex + endIndex)/2;

            if(target < letters[midIndex])
                endIndex = midIndex -1;
            else
                startIndex = midIndex +1;
        }
        return letters[startIndex% letters.length];     // Edge Case : Target element is greater than the Greatest element in Array,
                                                    // take Mod by length to wrap and return first element
    }
}
