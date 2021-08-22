package com.designanalysis.SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    private int[] array;
    public MergeSort(int[] array){
        this.array = array;
        sort(array);
    }
    public void sort(int[] array) {
        int n = array.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] s1 = Arrays.copyOfRange(array, 0, mid);
        int[] s2 = Arrays.copyOfRange(array, mid, n);

        sort(s1);
        sort(s2);

        merge(s1, s2, array);

    }

    private void merge(int[] s1, int[] s2, int[] array) {
        int i = 0;
        int j = 0;

        while ((i + j) < array.length) {
            if (j == s2.length || i < s1.length && s1[i] < s2[j]) {
                array[i + j] = s1[i++];
            } else {
                array[i + j] = s2[j++];
            }
        }
        System.out.println("The array is "+Arrays.toString(array));
    }

    public int[] getArray() {
        return array;
    }
}
