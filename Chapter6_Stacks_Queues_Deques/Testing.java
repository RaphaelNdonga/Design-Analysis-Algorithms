package com.designanalysis.Chapter6_Stacks_Queues_Deques;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
//        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
//        arrayStack.push(1);
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.push(3);
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.push(5);
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.pop();
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.push(67);
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.pop();
//        System.out.println(Arrays.toString(arrayStack.array));
//        arrayStack.pop();
//        System.out.println(Arrays.toString(arrayStack.array));
//        LinkedStack<Integer> arrayStack = new LinkedStack<>();
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//        System.out.println(arrayStack.top());
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());

//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        arrayQueue.enqueue(1);
//        arrayQueue.enqueue(2);
//        System.out.println(Arrays.toString(arrayQueue.array));
//        arrayQueue.dequeue();
//        System.out.println(Arrays.toString(arrayQueue.array));
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        System.out.println(linkedQueue.getFirst());
        linkedQueue.dequeue();
        System.out.println(linkedQueue.getFirst());
    }
}
