package com.designanalysis.Chapter7_List_Iterator_ADTs;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
//        DynamicList<Integer> dynamicList = new DynamicList<>(3);
//        dynamicList.add(0,1);
//        dynamicList.add(0,1);
//        dynamicList.add(0,1);
//        dynamicList.add(0,1);
//        System.out.println(Arrays.toString(dynamicList.array));
        LinkedPositionalList<Integer> positionalList = new LinkedPositionalList<>();
        Position<Integer> p1 = positionalList.addFirst(1);
        Position<Integer> p2 = positionalList.addLast(2);
        Position<Integer> p3 = positionalList.addAfter(p1,3);
        Position<Integer> p4 = positionalList.addBefore(p2,4);
        System.out.println(positionalList.getFirst() == p1);
        System.out.println(positionalList.getAfter(p1) == p3);
        System.out.println(positionalList.getAfter(p3));
        System.out.println(positionalList.getBefore(p2));
        System.out.println(p4);
    }
}
