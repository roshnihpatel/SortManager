package com.sparta.rp.sorters;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter {
    private static final Logger logger = Logger.getLogger("Bubble Sort logger");
    private static final ConsoleHandler handler = new ConsoleHandler();



    public static void main(String[] args) {

        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        Sorter bubbleSort = new BubbleSorter();
        bubbleSort.sortArray(new int[]{5, 2, 4, 7, 1, 2});

    }


    @Override
    public int[] sortArray(int[] unsortedArray) {
       int[] arrToSort = unsortedArray.clone();

        logger.log(Level.INFO,"This is the array to sort: " + Arrays.toString(unsortedArray));

            for(int loops= 0; loops < arrToSort.length-1; loops++){
                arrToSort= oneIterationSort(arrToSort);
            }
        logger.log(Level.INFO,"This is the sorted array: " + Arrays.toString(arrToSort));
            return arrToSort;

    }
    private static int[] oneIterationSort(int[] unsortedArray){
        logger.log(Level.FINE,"This is before an iteration: " + Arrays.toString(unsortedArray) );
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            logger.log(Level.FINER, "These are the comparisons made:  "+  unsortedArray[i] +">" + unsortedArray[i + 1] +": "+ (unsortedArray[i] > unsortedArray[i + 1])) ;
            if (unsortedArray[i] > unsortedArray[i + 1]) {
                swap(unsortedArray, i);
            }

        }
        logger.log(Level.FINE,"This is after an iteration: " + Arrays.toString(unsortedArray) );
        return unsortedArray;
    }

    private static void swap(int[] unsortedArray, int i) {
        logger.log(Level.FINE,"A swap occurred between " + unsortedArray[i] + " and " + unsortedArray[i+1] );

        int temp;
        temp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[i + 1];
        unsortedArray[i + 1] = temp;
    }
}
