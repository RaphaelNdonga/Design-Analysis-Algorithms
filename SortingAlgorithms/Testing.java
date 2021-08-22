package com.designanalysis.SortingAlgorithms;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        int[] array = {8,4,2,3,56,6,34,6,536,534,53433,233,46,5,4,5};
//        BubbleSort bubbleSort = new BubbleSort(array);
//        InsertionSort insertionSort = new InsertionSort(array);
//        System.out.println(Arrays.toString(bubbleSort.getArray()));
//        System.out.println(Arrays.toString(insertionSort.getArray()));
        MergeSort mergeSort = new MergeSort(array);
        System.out.println(Arrays.toString(mergeSort.getArray()));
    }
}
