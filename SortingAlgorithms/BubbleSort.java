package com.designanalysis.SortingAlgorithms;

/**
 * Compares adjacent elements, starting from the left and swaps them if they are in the wrong order.
 * It repeats this n number of times, where n is the size of the array.
 * The time complexity is O(n^2)
 * @author raphael
 */
public class BubbleSort {
    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
        sortArray();
    }

    private void sortArray() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i ; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = startTime - endTime;
        System.out.println("The elapsed time is " + elapsedTime);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
