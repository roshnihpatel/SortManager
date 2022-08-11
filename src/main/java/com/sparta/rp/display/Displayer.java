package com.sparta.rp.display;


import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.Sorter;
import com.sparta.rp.start.SortFactory;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Displayer {
    static Scanner userInput = new Scanner(System.in);
    static int option = 0;

    public static void main(String[] args) throws SorterLoaderException {
        userInterface();

    }

    public static void userInterface() {

        System.out.println("Welcome to Sort Manager");
        while (option != 3) {
            option = makeSorterSelection();
            if (option == 3) {
                break;
            }
            try{
                Sorter sorter = SortFactory.getSorter(option);
                option = makeArrayLengthSelection();
                int[] arrToSort = getRandomArray(option);
                printSorting(arrToSort, sorter);
            }catch (SorterLoaderException e){
                System.out.println(e.getMessage());
            }


        }

    }

    private static int[] getRandomArray(int length) {
        Random rando = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = rando.nextInt(1000);
        }
        return randomArray;

    }

    private static int makeSorterSelection() {
        System.out.println("Please select an option");
        System.out.println("1: Bubble Sort \n3: Quit");
        option = userInput.nextInt();

        return option;

    }

    private static int makeArrayLengthSelection() {
        System.out.println("Select length of array to sort");
        return userInput.nextInt();

    }

    private static void printSorting(int[] arrToSort, Sorter sorter) {
        System.out.println("Array before sorting: " + Arrays.toString(arrToSort));
        int[] sortedArray = sorter.sortArray(arrToSort);
        System.out.println("Array after sorting: " + Arrays.toString(sortedArray));

    }


}


