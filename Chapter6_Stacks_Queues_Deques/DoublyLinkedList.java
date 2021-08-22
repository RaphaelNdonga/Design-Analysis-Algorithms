package com.designanalysis.Chapter6_Stacks_Queues_Deques;

public class DoublyLinkedList<E> implements Deque<E> {

    private static class Node<E> {
        private E element;
        private Node<E> previous;
        private Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private int size = 0;
    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList() {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> predecessor = header;
        Node<E> successor = header.getNext();
        addBetween(element, predecessor, successor);
        size++;
    }

    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> currentNode = new Node<>(element, predecessor, successor);
        predecessor.setNext(currentNode);
        successor.setPrevious(currentNode);
    }

    @Override
    public void addLast(E element) {
        Node<E> predecessor = trailer.getPrevious();
        Node<E> successor = trailer;
        addBetween(element, predecessor, successor);
    }

    @Override
    public E removeFirst() {
        return remove(header.getNext());
    }

    private E remove(Node<E> currentNode) {
        Node<E> predecessor = currentNode.getPrevious();
        Node<E> successor = currentNode.getNext();
        E temp = currentNode.getElement();
        predecessor.setNext(currentNode.getNext());
        successor.setPrevious(currentNode.getPrevious());
        size--;
        return temp;
    }

    @Override
    public E removeLast() {
        return remove(trailer.getPrevious());
    }

    @Override
    public E getFirst() {
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }

    @Override
    public E getLast() {
        if(isEmpty()) return null;
        return trailer.getPrevious().getElement();
    }
}
