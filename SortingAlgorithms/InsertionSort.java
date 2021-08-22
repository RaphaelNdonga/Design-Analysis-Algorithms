package com.designanalysis.SortingAlgorithms;

public class InsertionSort {
    private int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
        sortArray(array);
    }

    private void sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
