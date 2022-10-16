package org.example.binaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BinaryTreeLinkedIn {
    private TreeNode root;


    public void delete(int data) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        if (current == null)
            return;

        while (current != null && current.getData() != data) {
            parent = current;
            if (current.getData() < data) {
                current = current.getLeftNode();
                isLeftChild = true;
            } else {
                current = current.getRightNode();
                isLeftChild = false;

            }
        }
        if (current == null)
            return;
//case one : Node to be deleted is a leaf
        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.setLeftNode(null);
                } else {
                    parent.setRightNode(null);
                }
            }
        }

        //case 2: if Node to be deleted has one child!!!

        else if (current.getLeftNode() == null) {
            if (current == root) {
                root = current.getRightNode();
            } else if (isLeftChild) {
                parent.setLeftNode(current.getRightNode());
            } else {
                parent.setRightNode(current.getRightNode());

            }
        } else if (current.getRightNode() == null) {
            if (current == root) {
                root = current.getLeftNode();
            } else if (isLeftChild) {
                parent.setLeftNode(current.getLeftNode());
            } else {
                parent.setRightNode(current.getLeftNode());
            }

        }

        ///case 3 : Node to be deleted has two children!!

        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.setLeftNode(successor);
            } else {
                parent.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        }
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRightNode();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeftNode();
        }
        if (successor != node.getRightNode()) {
            parentOfSuccessor.setLeftNode(successor.getRightNode());
            successor.setRightNode(node.getRightNode());
        }
        return successor;
    }
}
