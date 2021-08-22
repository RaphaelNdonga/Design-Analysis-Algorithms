package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public class ArrayStack<E> implements Stack<E> {
    private int capacity = 1000;

    final E[] array;

    private int index = -1;

    public ArrayStack() {
        this.array = (E[]) new Object[capacity];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if(size() == array.length) throw new IllegalStateException("The stack is full");
        array[++index] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E temp = array[index];
        array[index] = null;
        index--;
        return temp;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return array[index];
    }
}
