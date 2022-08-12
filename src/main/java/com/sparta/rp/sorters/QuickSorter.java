package com.sparta.rp.sorters;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("Quick Sort logger");


    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logger.addHandler(handler);
        Sorter qsort = new QuickSorter();
        qsort.sortArray(new int[]{5, 2, 4, 7, 1, 2});




    }

    @Override
    public int[] sortArray(int[] unsortedArray) {
        logger.log(Level.INFO,"This is the array to sort: " + Arrays.toString(unsortedArray));
        int[] arrToSort = unsortedArray.clone();
        int lastIndex = arrToSort.length-1;
        int[] sortedArray = quickSort(arrToSort, 0, lastIndex);


        logger.log(Level.INFO,"This is the sorted array: " + Arrays.toString(unsortedArray));

        return sortedArray;
    }

    private int[] quickSort(int[] arrToSort, int start, int end) {
        logger.log(Level.FINE,"These are the arrays, start and end arguments of quickstart: " + Arrays.toString(arrToSort) + ", " + start + ", " + end );
        if(start<end){
            int partitionIndex = partition(arrToSort, start, end);
            quickSort(arrToSort, start, partitionIndex-1);
            quickSort(arrToSort,partitionIndex+1, end);
        }
        return arrToSort;
    }

    private int partition(int[] arrToSort, int start, int end){


        int pivot = arrToSort[end];
        logger.log(Level.FINE,"This is the pivot " + pivot);
        int pointer = start -1;
        for (int i = start; i < end; i++){
            if (arrToSort[i] < pivot){
                pointer++;
                swap(arrToSort,pointer, i);
            }

        }
        swap(arrToSort, pointer +1, end);
        return pointer+1;

    }
    private static void swap(int[] arrToSort, int i, int j) {
        //logger.log(Level.FINE,"A swap occurred between " + unsortedArray[i] + " and " + unsortedArray[i+1] );

        int temp;
        temp = arrToSort[i];
        arrToSort[i] = arrToSort[j];
        arrToSort[j] = temp;
    }


}
