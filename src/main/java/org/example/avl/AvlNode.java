package org.example.avl;

public class AvlNode {
    int key, height;
    AvlNode left, right;

    AvlNode(int d) {
        key = d;
        height = 1;
    }
}
