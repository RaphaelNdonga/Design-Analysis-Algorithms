package com.designanalysis.Chapter6_Stacks_Queues_Deques;

import com.designanalysis.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E>{
    final SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
    @Override
    public int size() {
        return singlyLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(E element) {
        singlyLinkedList.addFirst(element);
    }

    @Override
    public E pop() {
        return singlyLinkedList.removeFirst();
    }

    @Override
    public E top() {
        return singlyLinkedList.getFirst();
    }
}
