package com.sparta.rp.start;

import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.BubbleSorter;
import com.sparta.rp.sorters.Sorter;

public class SortFactory {
    public static Sorter getSorter(int option) throws SorterLoaderException {
        return switch (option) {
            case 1 -> new BubbleSorter();
            default -> throw new SorterLoaderException(option + "is an invalid selection");
        };


    }
}
