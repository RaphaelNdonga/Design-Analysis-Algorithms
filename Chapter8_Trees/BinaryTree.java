package com.designanalysis.Chapter8_Trees;

import com.designanalysis.Position;

/**
 * A binary tree is a modified tree that only has 2 children. left and right.
 * @author raphael
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E> {
    Position<E> getLeft(Position<E> p) throws IllegalArgumentException;
    Position<E> getRight(Position<E> p) throws IllegalArgumentException;
    Position<E> getSibling(Position<E> p) throws IllegalArgumentException;
}
