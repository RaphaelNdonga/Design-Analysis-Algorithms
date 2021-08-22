package com.designanalysis.Chapter7_List_Iterator_ADTs;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        DynamicList<Integer> dynamicList = new DynamicList<>(3);
        dynamicList.add(0,1);
        dynamicList.add(0,1);
        dynamicList.add(0,1);
        dynamicList.add(0,1);
        System.out.println(Arrays.toString(dynamicList.array));
    }
}
