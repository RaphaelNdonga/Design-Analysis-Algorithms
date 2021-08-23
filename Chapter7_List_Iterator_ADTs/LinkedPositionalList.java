package com.designanalysis.Chapter7_List_Iterator_ADTs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The only difference between this and the doubly linked list implementation is that this one utilizes
 * the positional abstraction that is necessary for encapsulation (hiding the unnecessary details from the
 * user).
 * The user will know only of the 'Position' but we, the developers, are implementing the 'Node'.
 * @param <E> Generic type
 * @author raphael
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
    //-------------------------------nested node class----------------------------------------------
    protected static class Node<E> implements Position<E> {
        @Override
        public String toString() {
            return getElement().toString();
        }

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    //------------------------------------End of nested node class--------------------------------------

    //-----------------------------------nested position iterator class---------------------------------

    public class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = getFirst();
        private Position<E> recent = null;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = getAfter(cursor);
            return recent;
        }

        @Override
        public void remove() throws IllegalArgumentException {
            if (recent == null) throw new IllegalArgumentException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }
    //------------------------------end of nested position iterator class --------------------------------

    //------------------------------nested position iterable class----------------------------------------
    public class PositionIterable implements Iterable<Position<E>>{

        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
    //-------------------------------end of position iterable class---------------------------------------

    //-------------------------------element iterator class----------------------------------------------

    public class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    //--------------------------------end of element iterator class----------------------------------------

    private int size = 0;
    private Node<E> header;
    private Node<E> trailer;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    public Iterable<Position<E>> positions(){
        return new PositionIterable();
    }

    public Iterator<E> iterator(){
        return new ElementIterator();
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("P is not a valid node");
        }
        Node<E> node = (Node<E>) p;

        if (node.getNext() == null) { // this is how we have decided to check the validity of a node in a linked list
            throw new IllegalArgumentException("The node is invalid");
        }
        return node;
    }

    private Node<E> addBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newNode = new Node<>(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;

        return newNode;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public Position<E> addFirst(E element) {
        return addBetween(element, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E element) {
        return addBetween(element, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E element) throws IllegalArgumentException {
        Node<E> successor = validate(p);

        return addBetween(element, successor.getPrev(), successor);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E element) throws IllegalArgumentException {
        Node<E> predecessor = validate(p);
        return addBetween(element, predecessor, predecessor.getNext());
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        E element = currentNode.getElement();
        Node<E> predecessor = currentNode.getPrev();
        Node<E> successor = currentNode.getNext();

        currentNode.setElement(null);
        currentNode.setNext(null);
        currentNode.setPrev(null);
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return element;
    }

    @Override
    public E set(Position<E> p, E element) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        currentNode.setElement(element);
        return element;
    }

    @Override
    public Position<E> getFirst() {
        return header.getNext();
    }

    @Override
    public Position<E> getLast() {
        return trailer.getPrev();
    }

    @Override
    public Position<E> getBefore(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        return currentNode.getPrev();
    }

    @Override
    public Position<E> getAfter(Position<E> p) throws IllegalArgumentException {
        Node<E> currentNode = validate(p);
        return currentNode.getNext();
    }
    private Position<E> position(Node<E> node){
        if(node == header||node == trailer){
            return null;
        }
        return node;
    }
}
