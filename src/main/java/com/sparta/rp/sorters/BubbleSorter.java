package com.sparta.rp.sorters;

import java.util.Arrays;

public class BubbleSorter implements Sorter {


    @Override
    public int[] sortArray(int[] arrToSort) {



            for(int loops= 0; loops < arrToSort.length-1; loops++){
                arrToSort= oneIterationSort(arrToSort);
            }

            return arrToSort;

    }
    private static int[] oneIterationSort(int[] unsortedArray){

        for (int i = 0; i < unsortedArray.length - 1; i++) {
            if (unsortedArray[i] > unsortedArray[i + 1]) {
                swap(unsortedArray, i);
            }
            //System.out.println("Values are "+ Arrays.toString(unsortedArray));
        }
        return unsortedArray;
    }

    private static void swap(int[] unsortedArray, int i) {
        int temp;
        temp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[i + 1];
        unsortedArray[i + 1] = temp;
    }
}
