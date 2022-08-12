package com.sparta.rp.start;

import com.sparta.rp.exceptions.ChildNotFoundException;
import com.sparta.rp.exceptions.SorterLoaderException;
import com.sparta.rp.sorters.BubbleSorter;
import com.sparta.rp.sorters.Sorter;
import com.sparta.rp.sorters.binarytree.BinaryTree;
import com.sparta.rp.sorters.binarytree.BinaryTreeImpl;

public class SortFactory {
    public static Sorter getSorter(int option) throws SorterLoaderException {

        return switch (option) {
            case 1 -> new BubbleSorter();
            case 2 -> new BinaryTreeImpl();
            default -> throw new SorterLoaderException(option + " is an invalid selection");
        };


    }
}
