package com.designanalysis.Chapter9_PriorityQueues;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    protected int getLeft(int index) {
        return 2 * index + 1;
    }

    protected int getRight(int index) {
        return 2 * index + 2;
    }

    protected int getParent(int index) {
        return index / 2 - 1;
    }

    protected boolean hasLeft(int index) {
        return getLeft(index) < heap.size();
    }

    protected boolean hasRight(int index) {
        return getRight(index) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.add(j, temp);
    }

    protected void upHeap(int j) {
        while (j > 0) {
            int parent = getParent(j);
            if (compare(heap.get(j), heap.get(parent)) >= 0) break;
            swap(j, parent);
            j = parent;
        }
    }

    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = getLeft(j);
            int smallestChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = getRight(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) >= 0) {
                    smallestChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallestChildIndex), heap.get(j)) >= 0) break;
            swap(j, smallestChildIndex);
            j = smallestChildIndex;
        }
    }

    public int getSize() {
        return heap.size();
    }

    public Entry<K, V> getMin() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        PQEntry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }

    public Entry<K, V> removeMin() {
        if(heap.isEmpty()) return null;
        Entry<K,V> min = getMin();
        swap(0,getSize()-1);
        heap.remove(getSize()-1);
        downHeap(0);
        return min;
    }
}
