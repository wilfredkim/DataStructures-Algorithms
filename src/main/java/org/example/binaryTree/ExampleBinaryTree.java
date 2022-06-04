package org.example.binaryTree;

import java.util.ArrayList;

public class ExampleBinaryTree {
    Node root;

    // Constructors
    ExampleBinaryTree(int key) {
        root = new Node(key);
    }

    ExampleBinaryTree() {
        root = null;
    }

    public static void main(String... args) {
        ExampleBinaryTree binaryTree = new ExampleBinaryTree();
        binaryTree.root = new Node(8);

        binaryTree.root.left = new Node(5);
        binaryTree.root.right = new Node(4);

        binaryTree.root.left.left = new Node(9);
        binaryTree.root.left.right = new Node(7);

        binaryTree.root.left.right.left = new Node(1);
        binaryTree.root.left.right.right = new Node(12);
        binaryTree.root.left.right.right.left = new Node(2);

        binaryTree.root.right.right = new Node(11);
        binaryTree.root.right.right.left = new Node(3);


        ExampleBinaryTree tree = new ExampleBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println(
                "\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println(
                "\nPostorder traversal of binary tree is ");
        tree.printPostorder();


    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }


    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }


    public int solution(int[] A, int X, int Y) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - (2 * X - 1); i++) {
            int cost = A[i], j = 1;
            while (j < X) {
                cost += A[i + j * Y];
                j++;
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public int solution(int N ) {
        int current = N+1;
        boolean containsConsecutiveNumbers = containsConsecutiveNumbers(current);
        if (containsConsecutiveNumbers){
            return solution(current);
        }else return current;
    }


    boolean containsConsecutiveNumbers(int N){
        String numberString = String.valueOf(N);
        char[] chars = numberString.toCharArray();
        for(int i = 1; i<chars.length; i++){
            if(chars[i-1] == chars[i ])
                return true;
        }
        return false;
    }
}
