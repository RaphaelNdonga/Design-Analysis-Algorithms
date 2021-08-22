package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public interface Deque<E> {
    int getSize();

    boolean isEmpty();

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();

    E getFirst();

    E getLast();
}
