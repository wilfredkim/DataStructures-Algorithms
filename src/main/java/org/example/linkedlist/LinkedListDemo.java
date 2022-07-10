package org.example.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(9);
        linkedList.insertAtHead(11);
        linkedList.insertAtHead(21);
        linkedList.insertAtHead(15);
        linkedList.insertAtHead(8);
        linkedList.deleteFromHead();

        System.out.println(linkedList);
        System.out.println(linkedList.length());

        System.out.println(linkedList.find(11));
        System.out.println(linkedList.find(10));
    }
}
