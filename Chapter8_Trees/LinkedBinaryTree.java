package com.designanalysis.Chapter8_Trees;

import com.designanalysis.Chapter7_List_Iterator_ADTs.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    //----------------------Nested Node Class-------------------------------
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;

        public Node(E element, Node<E> left, Node<E> right, Node<E> above) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = above;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> above) {
            this.parent = above;
        }

        public void setRight(Node<E> rightNode) {
            this.right = rightNode;
        }
    }
    //-------------------------------End of nested node class-----------------------------

    //Factory function that creates a new node.
    protected Node<E> createNode(E element, Node<E> left, Node<E> right, Node<E> parent) {
        return new Node<>(element, left, right, parent);
    }

    //----------------------------Linked Binary Tree instance variables.------------------------
    protected Node<E> root = null;
    protected int size = 0;

    //Constructor
    public LinkedBinaryTree() {
    }

    ;

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position type");
        }
        //Safe cast because Node implements Interface.
        Node<E> node = (Node<E>) p;
        if (node == node.getParent()) {
            throw new IllegalArgumentException("P is no longer in the tree");
        }
        return node;
    }

    //--------------------------getter methods---------------------------------

    @Override
    public Position<E> getLeft(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        return currentNode.getLeft();
    }

    @Override
    public Position<E> getRight(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        return currentNode.getRight();
    }

    @Override
    public Position<E> getRoot() {
        return root;
    }

    @Override
    public Position<E> getParent(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        return currentNode.getParent();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    //--------------------------------end of getter methods-----------------------------------

    //---------------------------------setter methods-----------------------------------------

    public Position<E> addRoot(E element) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("The tree is not empty");
        }
        root = createNode(element, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Node<E> parent, E element) throws IllegalArgumentException {
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("The parent node already has a left child");
        }
        Node<E> leftChild = createNode(element, null, parent.getRight(), parent);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight(Node<E> parent, E element) throws IllegalArgumentException {
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("The parent node already has a right child");
        }
        Node<E> rightNode = createNode(element, parent.getLeft(), null, parent);
        parent.setRight(rightNode);
        size++;
        return rightNode;
    }

    public E set(Position<E> p, E element) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        E previousElement = p.getElement();
        currentNode.setElement(element);
        return previousElement;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
        Node<E> currentNode = validate(p);

        if (isInternal(p)) {
            throw new IllegalArgumentException("Attach only to a leaf");
        }
        size+=t1.getSize()+t2.getSize();
        if(!t1.isEmpty()) {
            t1.root.setParent(currentNode);
            currentNode.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if(!t2.isEmpty()) {
            t2.root.setParent(currentNode);
            currentNode.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node and replaces it with its child if it has one child.
     *
     * @param p is Position element
     * @return
     */
    public E remove(Position<E> p) {
        Node<E> currentNode = validate(p);
        if (getNumChildren(p) == 2) {
            throw new IllegalArgumentException("The node has 2 children therefore it cannot be removed");
        }
        Node<E> childNode = currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight();

        //The set the child's parent to the grandparent of this child node
        if (childNode != null) {
            childNode.setParent(currentNode.getParent());
        }

        if(currentNode == root){
            root = childNode;
        }else{
            Node<E> parentNode = currentNode.getParent();
            if(currentNode == parentNode.getLeft()){
                parentNode.setLeft(childNode);
            }else{
                parentNode.setRight(childNode);
            }
        }
        size--;

        E previousElement = currentNode.getElement();
        currentNode.setElement(null);
        currentNode.setLeft(null);
        currentNode.setRight(null);
        currentNode.setParent(currentNode);
        return previousElement;
    }
}
//----------------------------------------end of linked binary tree class--------------------------------
