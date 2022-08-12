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
        while (sorterSelection != 3) {
            sorterSelection = UserSelection.makeSorterSelection(userInput);
            if (sorterSelection == 3) {
                System.out.println("Goodbye");
                break;
            }
            try{
                arrayLengthSelection = UserSelection.makeArrayLengthSelection(userInput);
                int[] arrToSort = RandomArrayGenerator.getArrayOfSelectedLength(arrayLengthSelection);
                Sorter sorter = SortFactory.getSorter(sorterSelection);


                DisplaySorter.printSorting(arrToSort, sorter);
            }catch (SorterLoaderException e){
                System.out.println(e.getMessage());
            }


        }

    }





}


