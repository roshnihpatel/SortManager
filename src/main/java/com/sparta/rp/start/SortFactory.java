package com.sparta.rp.start;

import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.BubbleSort;
import com.sparta.rp.sorters.Sorter;

public class SortFactory {
    public static Sorter getSorter(int option) throws SorterLoaderException {
        return switch (option) {
            case 1 -> new BubbleSort();
            default -> throw new SorterLoaderException(option + "is an invalid selection");
        };


    }
}
