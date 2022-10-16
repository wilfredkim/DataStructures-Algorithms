package org.example.binaryTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    public TreeNode(int data) {
        this.data = data;
    }

    private int data;

    private TreeNode leftNode;

    private TreeNode rightNode;

    //using binary tree search
    public TreeNode find(int data) {
        if (this.data == data) {
            return this;
        }
        if (this.data < data && leftNode != null) {
            return find(leftNode.data);
        }
        if (rightNode != null) {
            return find(rightNode.data);
        }
        return null;
    }

    public void insert(int data) {
        if (this.data > data) {
            if (this.rightNode == null) {
                this.rightNode = new TreeNode(data);
            } else {
                this.rightNode.insert(data);
            }
        }
        if (this.leftNode == null) {
            this.leftNode = new TreeNode(data);
        } else {
            this.leftNode.insert(data);
        }
    }


}
