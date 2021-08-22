package com.designanalysis.Chapter10_Maps;

import com.designanalysis.Chapter9_PriorityQueues.Entry;

public interface Map <K,V>{
    int getSize();
    boolean isEmpty();

    V put(K key,V value);
    V get(K key);
    V remove(K key);

    Iterable<K> getKeySet();
    Iterable<V> getValues();
    Iterable<Entry<K,V>> getEntrySet();
}
