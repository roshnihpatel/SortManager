package com.sparta.rp.sorters;

import java.util.Arrays;

public class BubbleSorter implements Sorter {


    @Override
    public int[] sortArray(int[] arrToSort) {

            int[] sortedArray = new int[arrToSort.length];
            System.arraycopy(arrToSort, 0, sortedArray,0, arrToSort.length);
            for(int loops= 0; loops < arrToSort.length-1; loops++){
                sortedArray= oneIterationSort(sortedArray);
            }

            return sortedArray;

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
