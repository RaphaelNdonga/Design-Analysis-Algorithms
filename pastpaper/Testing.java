package com.designanalysis.pastpaper;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        double[] array = {11,21,32,43,54,65};
//        PrefixAverage prefixAverage = new PrefixAverage(array);

        System.out.println(Arrays.toString(prefixAverage(array)));
    }

    public static double[] prefixAverage(double[] array){
        double[] prefixAverageArray = new double[array.length];
        double total = 0;
        for(int j = 0;j< array.length;j++){
            total = total + array[j];
            double average = total/(j+1);
            prefixAverageArray[j] = average;
        }
        return prefixAverageArray;
    }
}
