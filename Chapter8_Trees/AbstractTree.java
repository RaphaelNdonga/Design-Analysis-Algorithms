package com.designanalysis.Chapter8_Trees;

import com.designanalysis.Position;

/**
 * This abstract tree creates the methods : height and depth.
 * It also explicitly dictates isEmpty, isInternal and isExternal, because their values can be obtained from
 * other methods in Tree such as getSize,getNumChildren and getRoot.
 * @author raphael
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return getNumChildren(p)>0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return getNumChildren(p)==0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == getRoot();
    }

    /**
     * The depth of a node is its position from the top of the tree.
     * The root's position is 0
     * @param p position of element
     * @return an integer recursively if base case not met
     */
    public int depth(Position<E> p){
        if(p == getRoot()){
            return 0;
        }
        //adds one after every parent node until it reaches the root node
        return (1+depth(getParent(p)));
    }

    /**
     * The height of a node is the position from the bottom of the tree.
     * @return 
     */
    public int height(Position<E> p){
        int h = 0;
        for(Position<E> c : getChildren(p)){
            //check for the node with the most children and add one per operation.
            //because the operation is checking children, the one with the most children will be returned.
            h = Math.max(h,height(c)+1);
        }
        return h;
    }
}
