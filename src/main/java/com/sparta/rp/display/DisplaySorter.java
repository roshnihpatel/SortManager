package com.sparta.rp.display;

import com.sparta.rp.sorters.Sorter;

import java.util.Arrays;

public class DisplaySorter {
    public static void printSorting(int[] unsortedArr, Sorter sorter) {
        int [] arrToSort = unsortedArr.clone();
        System.out.println("Array before sorting: " + Arrays.toString(unsortedArr));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrToSort);
        long finish = System.nanoTime();
        long timeTaken = (finish - start) / 10000;

        System.out.println("Array after sorting: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

}
