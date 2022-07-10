package org.example.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoublyLinkedNode {

    public int data;

    private DoublyLinkedNode nextNode;

    private DoublyLinkedNode previousNode;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data: " + this.data;
    }
}
