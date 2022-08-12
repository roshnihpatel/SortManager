package com.sparta.rp.sorters;

import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.start.SortFactory;
import org.junit.jupiter.api.*;

import java.util.Random;

public class SorterTester {
    public static Sorter sorter;

    @BeforeEach
    public void getSorter() throws SorterLoaderException {
        sorter = SortFactory.getSorter(3);
    }
    @Test
    @DisplayName("Given an array with an odd length return the the sorted array")
    void givenAnArrayWithAnOddNumberOfElementsReturnTheSortedArray() {
        int[] unsortedArray = {45, 12, 41, 27, 67, 55, 82, 31,99};
        int[] expected = {12, 27, 31, 41, 45, 55, 67, 82,99};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }
    @Test
    @DisplayName("Given an array with an even length return the the sorted array")
    void givenAnArrayWithAnEvenNumberOfElementReturnTheSortedArray() {
        int[] unsortedArray = {11, 74, 13, 64, 37, 75, 2, 41};
        int[] expected = {2, 11, 13, 37, 41, 64, 74, 75};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    @DisplayName("Given an array with duplicates return the sorted array")
    void givenArrayReturnWithDuplicatesReturnTheSortedArray() {
        int[] unsortedArray = {11, 4, 5, 2, 7, 5, 2, 1};
        int[] expected = {1, 2, 2, 4, 5, 5, 7, 11};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }
    @Test
    @DisplayName("Given an array with only negative values return the the sorted array")
    void givenArrayWithOnlyNegativeValuesReturnTheSortedArray() {
        int[] unsortedArray = {-10, -18, -96, -11, -62, -79, -3, -910};
        int[] expected = {-910, -96, -79, -62, -18, -11, -10, -3};
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
    @DisplayName("Given a random array return a sorted array")
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
    @Test
    @DisplayName("Given an array with 1 element return the array")
    void givenAnArrayWithOneElementReturnTheArray() {
        int[] unsortedArray = {4};
        int[] expected = {4};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }
    @Test
    @DisplayName("Given an array with all the same elements return array")
    void givenAnArrayWithAllTheSameElementsReturnArray() {
        int[] unsortedArray = {1,1,1,1,1,1,1};
        int[] expected = {1,1,1,1,1,1,1};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }
    @Test
    @DisplayName("Given an array with max and min values return sorted array")
    void givenAnArrayWithMinAndMaxValuesReturnSortedArray() {
        int[] unsortedArray = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] expected = {Integer.MIN_VALUE,Integer.MAX_VALUE};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }
    @Test
    @DisplayName("Given a sorted array return the sorted array")
    void givenASortedArrayReturnSortedArray() {
        int[] unsortedArray = {2,9,34,51,61,82,102,302,555,657,999};
        int[] expected = {2,9,34,51,61,82,102,302,555,657,999};
        int[] answer = sorter.sortArray(unsortedArray);

        Assertions.assertArrayEquals(expected, answer);
    }



}
