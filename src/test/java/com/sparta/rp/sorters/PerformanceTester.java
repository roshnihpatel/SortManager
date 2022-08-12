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
        System.out.println("================\nBubble Sort\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));
        Sorter sorter = new BubbleSorter();
        double start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        double finish = System.nanoTime();
        double timeTaken = (finish - start) / 1000000;
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

    @Test
    public void JavaSorterTime() {
        int[] arrayToSort = unsortedArray.clone();
        System.out.println("================\nJava Sort\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));
        double start = System.nanoTime();
        Arrays.sort(arrayToSort);
        double finish = System.nanoTime();
        double timeTaken = (finish - start) / 1000000;
        System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

    @Test
    public void BinarySorterTime() {
        int[] arrayToSort = unsortedArray.clone();
        System.out.println("================\nBinary Sort\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));
        Sorter sorter = new BubbleSorter();
        double start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        double finish = System.nanoTime();
        double timeTaken = (finish - start) / 1000000;
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }

    @Test
    public void InsertionSorterTime() {
        int[] arrayToSort = unsortedArray.clone();
        System.out.println("================\nInsertion Sort\n================");
        System.out.println("Array To Sort: " + Arrays.toString(arrayToSort));
        Sorter sorter = new InsertionSorter();
        double start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        double finish = System.nanoTime();
        double timeTaken = (finish - start) / 1000000;
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Time to sort : " + timeTaken + "ms\n");

    }


}
