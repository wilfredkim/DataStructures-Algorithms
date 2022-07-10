package org.example.linkedlist;

public class DoublyLinkedList {
    private DoublyLinkedNode headNode;


    public void insertAtHead(int element) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(element);
        newNode.setNextNode(this.headNode);
        if (this.headNode != null) {
            this.headNode.setPreviousNode(newNode);
        }

        this.headNode = newNode;

    }

    public int length() {
        DoublyLinkedNode current = this.headNode;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        DoublyLinkedNode current = this.headNode;
        while (current != null) {
            result.append(current).append(" ,");
            current = current.getNextNode();
        }
        result.append("}");
        return result.toString();
    }

}
