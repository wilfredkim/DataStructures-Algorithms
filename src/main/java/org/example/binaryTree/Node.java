package org.example.binaryTree;

public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

/*tree with 4 Nodes
        ----
        1    <-- root
        /   \
        2     3
        /
        4

*/
// A Java program to introduce Binary Tree
class BinaryTree {
    Node root;

    // Constructors
    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }
    public  static void main (String ...args){

    }

}