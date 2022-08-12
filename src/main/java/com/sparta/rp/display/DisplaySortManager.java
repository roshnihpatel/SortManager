package com.sparta.rp.display;


import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.Sorter;
import com.sparta.rp.start.SortFactory;


import java.util.Scanner;

public class DisplaySortManager {
    static Scanner userInput = new Scanner(System.in);
    static int arrayLengthSelection = 0;
    static int sorterSelection = 0;


    public static void userInterface() {

        System.out.println("Welcome to Sort Manager");
        while (sorterSelection != 4) {
            sorterSelection = UserSelection.makeSorterSelection(userInput);
            if (sorterSelection == 4) {
                System.out.println("Goodbye");
                break;
            }
            try {

                Sorter sorter = SortFactory.getSorter(sorterSelection);
                arrayLengthSelection = UserSelection.makeArrayLengthSelection(userInput);
                int[] arrToSort = RandomArrayGenerator.getArrayOfSelectedLength(arrayLengthSelection);

                DisplaySorter.printSorting(arrToSort, sorter, sorterSelection);
            } catch (SorterLoaderException e) {
                System.out.println(e.getMessage());
            }


        }

    }


}


