package org.example;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueDataStructure {
    public static void main(String... args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> linkedListQueue = new LinkedList<>();
        Queue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(8);
        priorityQueue.add(52);
        priorityQueue.add(66);
        priorityQueue.add(5);

        linkedListQueue.add(9);
        linkedListQueue.add(8);
        linkedListQueue.add(52);
        linkedListQueue.add(66);
        linkedListQueue.add(1);

        priorityBlockingQueue.add(9);
        priorityBlockingQueue.add(8);
        priorityBlockingQueue.add(52);
        priorityBlockingQueue.add(66);
        priorityBlockingQueue.add(5);

        //inherits from collection interface
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Priority::::::::::: " + priorityQueue);
        System.out.println("POll:::: " + priorityQueue.poll());
        System.out.println("After pull::: " + priorityQueue);
        System.out.println("Peek::: " + priorityQueue.peek());

        System.out.println("Linked List::::::::::: " + linkedListQueue);
        System.out.println("POll " + linkedListQueue.poll());
        System.out.println("After pull " + linkedListQueue);
        System.out.println("Peek " + linkedListQueue.peek());

        System.out.println("Priority Blocking Queue::::::::::: " + linkedListQueue);
        System.out.println("POll " + linkedListQueue.poll());
        System.out.println("After pull " + linkedListQueue);
        System.out.println("Peek " + linkedListQueue.peek());

        Queue<Integer> integers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfQueries = scanner.nextInt();

        for (int i = 0; i < numberOfQueries; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {               // enqueue
                integers.add(scanner.nextInt());
            } else if (operation == 2) {        // dequeue
                integers.poll();
            } else if (operation == 3) {        // print/peek
                System.out.println(integers.peek());
            }
        }

    }
}
