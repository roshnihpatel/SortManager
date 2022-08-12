package com.sparta.rp.start;

import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.BubbleSorter;
import com.sparta.rp.sorters.InsertionSorter;
import com.sparta.rp.sorters.QuickSorter;
import com.sparta.rp.sorters.Sorter;
import com.sparta.rp.sorters.binarytree.BinaryTreeImpl;

public class SortFactory {
    public static Sorter getSorter(int option) throws SorterLoaderException {

        return switch (option) {
            case 1 -> new BubbleSorter();
            case 2 -> new BinaryTreeImpl();
            case 3 -> new InsertionSorter();
            case 4 -> new QuickSorter();
            default -> throw new SorterLoaderException(option + " is an invalid selection");
        };


    }
}
