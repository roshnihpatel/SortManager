package com.sparta.rp.sorters;

public class InsertionSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrToSort) {
            for (int i = 1; i < arrToSort.length; i++){
                int key = arrToSort[i];
                int j = i -1;

                j = moveSortedElementToTheRight(arrToSort, key, j);
                arrToSort[j+1] = key;

            }

            return arrToSort;
        }

    private int moveSortedElementToTheRight(int[] arrToSort, int key, int j) {
        while(j >= 0 && arrToSort[j] > key){
            arrToSort[j +1] = arrToSort[j];
            j--;
        }
        return j;
    }
}

