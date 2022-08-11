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


    public static void userInterface() {

        System.out.println("Welcome to Sort Manager");
        while (option != 3) {
            option = UserSelection.makeSorterSelection(userInput);
            if (option == 3) {
                System.out.println("Goodbye");
                break;
            }
            try{
                Sorter sorter = SortFactory.getSorter(option);
                option = UserSelection.makeArrayLengthSelection(userInput);
                int[] arrToSort = RandomArrayGenerator.getArrayOfSelectedLength(option);
                DisplaySorter.printSorting(arrToSort, sorter);
            }catch (SorterLoaderException e){
                System.out.println(e.getMessage());
            }


        }

    }





}


