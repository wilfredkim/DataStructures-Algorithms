package org.example.linkedlist;

import javax.swing.*;

public class LinkedList {
    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void deleteFromHead() {
        //head is set next node which makes previous head eligible for cabbage collection
        this.head = this.head.getNextNode();
    }

    public int length() {
        Node current = this.head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public Node find(int element) {
        Node current = this.head;
        while (current != null) {
            if (element == current.getData())
                return current;
            current = current.getNextNode();
        }
        return null;

    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        Node current = this.head;
        while (current != null) {
            result.append(current).append(" ,");
            current = current.getNextNode();
        }
        result.append("}");
        return result.toString();
    }
}
