package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E element);
    void dequeue();
    E getFirst();
}
