package com.designanalysis.Chapter6_Stacks_Queues_Deques;

import com.designanalysis.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E>{
    final SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
    @Override
    public int getSize() {
        return singlyLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        singlyLinkedList.addLast(element);
    }

    @Override
    public void dequeue() {
        singlyLinkedList.removeFirst();
    }

    @Override
    public E getFirst() {
        return singlyLinkedList.getFirst();
    }
}
