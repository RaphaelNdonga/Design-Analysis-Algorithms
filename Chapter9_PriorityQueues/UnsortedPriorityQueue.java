package com.designanalysis.Chapter9_PriorityQueues;

import com.designanalysis.LinkedPositionalList;
import com.designanalysis.Position;
import com.designanalysis.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
    private LinkedPositionalList<Entry<K,V>> positionalList = new LinkedPositionalList<>();

    public UnsortedPriorityQueue(){
        super();
    }
    public UnsortedPriorityQueue(Comparator<K> comp){
        super(comp);
    }

    public Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> small = positionalList.getFirst();
        for (Position<Entry<K,V>> walk:positionalList.positions()){
            if(compare(walk.getElement(), small.getElement())<0){
                small = walk;
            }
        }
        return small;
    }
    @Override
    public int getSize() {
        return positionalList.getSize();
    }

    @Override
    public Entry<K, V> getMin() {
        if(positionalList.isEmpty()) return null;
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if(positionalList.isEmpty()) return null;
        return positionalList.remove(findMin());
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newElement = new PQEntry<>(key,value);
        positionalList.addLast(newElement);
        return newElement;
    }
}
