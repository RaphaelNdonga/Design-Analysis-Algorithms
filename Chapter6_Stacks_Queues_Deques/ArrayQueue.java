package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity = 1000;
    final E[] array;
    private int index = 0;//always keeps track of the first element in the queue.
    private int size = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        array = (E[]) new Object[capacity];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void enqueue(E element) {
        if (size == array.length) throw new IllegalStateException("The Queue is full");
        int avail = (index + size) % array.length;
        array[avail] = element;
        size++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) return;
        E temp = array[index];
        array[index] = null;
        index = index + 1 % array.length;
        size--;
    }

    @Override
    public E getFirst() {
        return array[index];
    }
}
