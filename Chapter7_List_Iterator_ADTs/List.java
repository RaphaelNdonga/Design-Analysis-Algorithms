package com.designanalysis.Chapter7_List_Iterator_ADTs;

public interface List<E> {
    int getSize();

    boolean isEmpty();

    void add(int i,E element);

    E remove(int i);

    E set(int i, E element);

    E get(int i);

}
