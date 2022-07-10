package org.example.linkedlist;

public class DoubleEndedList {
    private Node head;
    private Node tail;



    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;

        }
        if (this.tail != null) {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }





}
