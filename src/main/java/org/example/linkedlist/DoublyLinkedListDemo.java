package org.example.linkedlist;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedNode = new DoublyLinkedList();
        doublyLinkedNode.insertAtHead(9);
        doublyLinkedNode.insertAtHead(11);
        doublyLinkedNode.insertAtHead(21);
        doublyLinkedNode.insertAtHead(15);
        doublyLinkedNode.insertAtHead(8);

        System.out.println(doublyLinkedNode);
    }
}
