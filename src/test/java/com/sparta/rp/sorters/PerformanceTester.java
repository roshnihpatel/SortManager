package com.sparta.rp.sorters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {
    public static int[] unsortedArray = new int[100];

    @BeforeAll
    public static void getRandomArray() {
        Random rando = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rando.nextInt(1001);
        }
    }


    @Test
    public void BubbleSorterTime() {
        int[] arrayToSort = unsortedArray.clone();
        Sorter sorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        long finish = System.nanoTime();
        long timeTaken = (finish - start) / 10000;
        System.out.println("================\nBubble Sort\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

    @Test
    public void JavaSorterTime() {
        int[] arrayToSort = unsortedArray.clone();
        System.out.println("================\nJava Sorter\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));

        long start = System.nanoTime();
        Arrays.sort(arrayToSort);
        long finish = System.nanoTime();
        long timeTaken = (finish - start) / 10000;

        System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }


}
