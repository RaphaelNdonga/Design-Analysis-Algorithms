package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E pop();
    E top();
}
