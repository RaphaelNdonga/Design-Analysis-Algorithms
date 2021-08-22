package com.designanalysis;

public interface PositionalList<E> {
    int getSize();
    boolean isEmpty();
    Position<E> addFirst(E element);
    Position<E> addLast(E element);
    Position<E> addBefore(Position<E> p,E element) throws IllegalArgumentException;
    Position<E> addAfter(Position<E> p,E element) throws IllegalArgumentException;
    E remove(Position<E> p) throws IllegalArgumentException;
    E set(Position<E> p,E element) throws IllegalArgumentException;
    Position<E> getFirst();
    Position<E> getLast();
    Position<E> getBefore(Position<E> p) throws IllegalArgumentException;
    Position<E> getAfter(Position<E> p) throws IllegalArgumentException;
}
