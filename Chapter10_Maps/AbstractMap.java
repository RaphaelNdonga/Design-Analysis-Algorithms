package com.designanalysis.Chapter10_Maps;

import com.designanalysis.Chapter9_PriorityQueues.Entry;

import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {
    public boolean isEmpty(){
        return getSize() == 0;
    }
    protected static class MapEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;

        public MapEntry(K key, V value){
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
        protected V setValue(V value){
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    private class KeyIterator implements Iterator<K>{

        private Iterator<Entry<K,V>> entries = getEntrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private class KeyIterable implements Iterable<K>{
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }
    public Iterable<K> getKeySet(){
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V>{

        private Iterator<Entry<K,V>> entries = getEntrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V>{
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }
    public Iterable<V> getValues(){
        return new ValueIterable();
    }
}
