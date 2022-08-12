package com.sparta.rp.sorters;

import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.start.SortFactory;
import org.junit.jupiter.api.*;

import java.util.Random;

public class SorterTester {
    public static Sorter sorter;

    @BeforeEach
    public void getSorter() throws SorterLoaderException {
        sorter = SortFactory.getSorter(2);
    }

    @Test
    @DisplayName("Given an array with duplicates return the the sorted array")
    void givenArrayReturnWithDuplicatesTheSortedArray() {
        int[] unsortedArray = {11, 4, 5, 2, 7, 5, 2, 1};
        int[] expected = {1, 2, 2, 4, 5, 5, 7, 11};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    @DisplayName("Given an array with negative values return the the sorted array")
    void givenArrayWithNegativeValuesReturnTheSortedArray() {
        int[] unsortedArray = {-1, -14, 6, 21, -65, 15, 3, 100};
        int[] expected = {-65, -14, -1, 3, 6, 15, 21, 100};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    @DisplayName("Given an empty array return an empty array")
    void givenAnEmptyArrayReturnAnEmptyArray() {
        int[] unsortedArray = {};
        int[] expected = {};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    @DisplayName("Given a random array return an sorted array")
    void givenARandomArrayReturnASortedArray() {
        int[] unsortedArray = new int[21];
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(1000);
        }

        int[] sortedArray = sorter.sortArray(unsortedArray);
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            Assertions.assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }


    }


}
