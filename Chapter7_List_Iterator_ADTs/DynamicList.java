package com.designanalysis.Chapter7_List_Iterator_ADTs;

import java.util.Arrays;

public class DynamicList<E> implements List<E> {
    private int capacity = 1000;
    E[] array;
    private int size = 0;

    public DynamicList() {
        this.array = (E[]) new Object[capacity];
    }

    public DynamicList(int initialCapacity) {
        capacity = initialCapacity;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int i, E element) {
        if (size == array.length) {
            System.out.println("Full, therefore resizing");
            resize(2 * size);
        }
        for (int k = size; k > i; k--) {
            array[k] = array[k - 1];//move the elements to the right
        }
        array[i] = element;
        size++;
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public E remove(int i) {
        E temp = array[i];
        for (int k = i; k < size; k++) {
            array[k] = array[k + 1];
        }
        array[size - 1] = null;
        size--;
        return temp;
    }

    @Override
    public E set(int i, E element) {
        E temp = array[i];
        array[i] = element;
        return temp;
    }

    @Override
    public E get(int i) {
        return array[i];
    }
}
