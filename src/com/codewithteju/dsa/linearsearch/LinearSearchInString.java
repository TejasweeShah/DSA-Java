package com.codewithteju.dsa.linearsearch;

import java.util.Scanner;

public class LinearSearchInString {

    public static void main(String[] args) {

        LinearSearchInString obj = new LinearSearchInString();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String : ");
        String searchString = scanner.nextLine();

        System.out.print("Enter a Character to Search : ");
        char charToSearch = scanner.next().charAt(0);

        if(obj.searchChar(searchString,charToSearch)){
            System.out.println("Character FOUND");
        }
        else{
            System.out.println("Character NOT FOUND");
        }


    }

    private boolean searchChar (String searchString, int charToSearch){

        if(searchString.length() == 0){
           return false;
        }

        for (int i = 0; i < searchString.length(); i++) {
            if(charToSearch == searchString.charAt(i)){
                return true;
            }
        }
        return false;
    }

    //Other Option
    boolean searchChar2(String searchString , int charToSearch){
        if(searchString.length() == 0)
            return false;

        for (int ch  : searchString.toCharArray()){
            if(ch == charToSearch)
                return true;
        }
        return false;
    }
}
