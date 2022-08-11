package com.sparta.rp.display;

import com.sparta.rp.sorters.Sorter;

import java.util.Arrays;

public class DisplaySorter {
    public static void printSorting(int[] arrToSort, Sorter sorter) {
        System.out.println("Array before sorting: " + Arrays.toString(arrToSort));
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrToSort);
        long finish = System.nanoTime();
        long timeTaken = (finish - start) / 10000;

        System.out.println("Array after sorting: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

}
