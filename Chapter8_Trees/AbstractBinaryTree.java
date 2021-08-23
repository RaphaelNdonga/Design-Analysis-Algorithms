package com.designanalysis.Chapter8_Trees;

import com.designanalysis.Chapter7_List_Iterator_ADTs.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary can only have 2 children therefore the getNumChildren and getChildren methods can be explicated here.
 *
 * @author raphael
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public int getNumChildren(Position<E> p) throws IllegalArgumentException {
        int counter = 0;
        if(getLeft(p) != null){
            counter++;
        }
        if(getRight(p) != null){
            counter++;
        }
        return counter;
    }

    @Override
    public Iterable<Position<E>> getChildren(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(getLeft(p) != null){
            snapshot.add(getLeft(p));
        }
        if(getRight(p) != null){
            snapshot.add(getRight(p));
        }
        //A list is also Iterable.
        return snapshot;
    }

    @Override
    public Position<E> getSibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = getParent(p);

        //if the current element is on the left of its parent, return the element at the right of its parent
        //and vice versa.
        if(p == getLeft(parent)){
            return getRight(parent);
        }else{
            return getLeft(parent);
        }
    }
}
