package com.designanalysis;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void addFirst(E element) {
        head = new Node<E>(element, head);
        if (getSize() == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newest = new Node<>(element, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (getSize() == 0) {
            tail = null;
        }
        return answer;
    }

    public E getFirst() {
        return head.getElement();
    }

}

