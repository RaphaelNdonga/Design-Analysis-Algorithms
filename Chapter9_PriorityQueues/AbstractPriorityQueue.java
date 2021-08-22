package com.designanalysis.Chapter9_PriorityQueues;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    protected static class PQEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;

        public PQEntry(K key,V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setKey(K key){
            this.key = key;
        }
        protected void setValue(V value){
            this.value = value;
        }
    }

    private Comparator<K> comparator;

    protected AbstractPriorityQueue(Comparator<K> comparator){
        this.comparator = comparator;
    }
    protected AbstractPriorityQueue(){
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K,V> a, Entry<K,V> b){
        return comparator.compare(a.getKey(),b.getKey());
    }

    protected boolean checkKey(K key)throws IllegalArgumentException{
        try{
            return comparator.compare(key,key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
