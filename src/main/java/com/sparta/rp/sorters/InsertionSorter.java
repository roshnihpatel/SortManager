package com.sparta.rp.sorters;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("Insertion Sort logger");




    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();

        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

    }
    @Override
    public int[] sortArray(int[] unsortedArray) {
        int[] arrToSort = unsortedArray.clone();
        logger.log(Level.INFO,"This is the array to sort: " + Arrays.toString(arrToSort));
            for (int i = 1; i < arrToSort.length; i++){
                int key = arrToSort[i];
                int j = i -1;

                j = moveSortedElementToTheRight(arrToSort, key, j);
                arrToSort[j+1] = key;

            }
        logger.log(Level.INFO,"This is the sorted array: " + Arrays.toString(arrToSort));
            return arrToSort;
        }

    private int moveSortedElementToTheRight(int[] arrToSort, int key, int j) {
        while(j >= 0 && arrToSort[j] > key){
            arrToSort[j +1] = arrToSort[j];
            j--;
        }
        return j;
    }
}

