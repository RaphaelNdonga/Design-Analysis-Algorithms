package com.designanalysis.Chapter8_Trees;

import com.designanalysis.Position;

/**
 * A tree is a non-linear way of storing data. One element does not follow the other in the way arrays do.
 * It is hierarchical in that there exists a parent that can have several children.
 * @author raphael
 * @param <E>
 */
public interface Tree<E> extends Iterable<E>{
    Position<E> getRoot();
    Position<E> getParent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> getChildren(Position<E> p) throws IllegalArgumentException;
    int getNumChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    boolean isEmpty();
    int getSize();

}
