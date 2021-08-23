package com.designanalysis.Chapter9_PriorityQueues;

import com.designanalysis.Chapter7_List_Iterator_ADTs.LinkedPositionalList;
import com.designanalysis.Chapter7_List_Iterator_ADTs.Position;

import java.util.Comparator;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
    private LinkedPositionalList<Entry<K,V>> positionalList = new LinkedPositionalList<>();
    public SortedPriorityQueue(){
        super();
    }
    public SortedPriorityQueue(Comparator<K> comparator){
        super(comparator);
    }
    @Override
    public int getSize() {
        return positionalList.getSize();
    }

    @Override
    public Entry<K, V> getMin() {
        return positionalList.getFirst().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        return positionalList.remove(positionalList.getFirst());
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new PQEntry<>(key,value);
        Position<Entry<K,V>> walk = positionalList.getLast();
        while (walk!=null && compare(newEntry,walk.getElement())<0){
            walk = positionalList.getBefore(walk);
        }
        if(walk == null){
            positionalList.addFirst(newEntry);
        }else{
            positionalList.addAfter(walk,newEntry);
        }
        return newEntry;
    }
}
