package com.designanalysis.Chapter9_PriorityQueues;

public interface PriorityQueue<K,V>{
    int getSize();
    boolean isEmpty();

    Entry<K,V> getMin();
    Entry<K,V> removeMin();
    Entry<K,V> insert(K key,V value) throws IllegalArgumentException;

}
