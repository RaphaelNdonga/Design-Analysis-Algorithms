package com.designanalysis.pastpaper;

public class PrefixAverage {
    private int[] originalArray;
    private int[] prefixAverageArray;

    public PrefixAverage(int[] array){
        originalArray = array;
        prefixAverageArray = array;
        createPrefixAverages();
    }

    private void createPrefixAverages() {
        int sum = 0;
        for(int i = 0;i< originalArray.length;i++){
            int numberOfItems = i+1;
            sum = sum + originalArray[i];
            prefixAverageArray[i] = sum/numberOfItems;
        }
    }
    public int[] getPrefixAverageArray(){
        return prefixAverageArray;
    }
}
