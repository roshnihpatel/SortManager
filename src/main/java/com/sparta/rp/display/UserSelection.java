package com.sparta.rp.display;

import java.util.Scanner;

public class UserSelection {
    public static String[] nameOfSorters = {"Bubble Sort", "Binary Sort", "Insertion Sort" ,"Quick Sort", "Quit"};

    public static int makeSorterSelection(Scanner userInput) {
        System.out.println("Please select an option");
        for (int i = 0; i < nameOfSorters.length; i++){
            System.out.println((i+1)+": "+ nameOfSorters[i]);
        }



        return userInput.nextInt();

    }

    public static int makeArrayLengthSelection(Scanner userInput) {
        System.out.println("Select length of array to sort");
        return userInput.nextInt();

    }
    public static String getSelectedSortedName(int option){
        return nameOfSorters[option-1];
    }
    public static int getQuitOptionNumber(){
        return nameOfSorters.length;
    }


}
