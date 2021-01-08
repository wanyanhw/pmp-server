package com.wyhw.pmp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 二叉树
 */
public class TwoFeatureTree {

    int size;

    class Node{
        private int data;
        private Node leftChild;
        private Node rightChild;
    }

    /**
     * the root of the tree
     */
    private Node root;

    public Node add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (root == null) {
            root = newNode;
            size ++;
            return newNode;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (data < parent.data) {
                current = parent.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    size ++;
                    return newNode;
                }
            } else {
                current = parent.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    size ++;
                    return newNode;
                }
            }
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.leftChild);
            System.out.println(root.data + "");
            display(root.rightChild);
        }
    }

    public Node find(int data) {
        Node current = root;
        while (current.data != data) {
            if (data < current.data) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public Node delete(int data) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.data != data) {
            parent = current;
            if (data < current.data) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            // 要删除的节点是叶子节点
            if (current == root) {
                root = null;
            } else if (isLeftChild){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            // 要删除的节点只有左子节点
            if (current == root) {
                root = current.leftChild;
            } else {
                parent.leftChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            // 要删除的节点只有右子节点
            if (current == root) {
                root = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return current;
    }

    private Node getSuccessor(Node deletedNode) {
        Node successor = deletedNode;
        Node successorParent = deletedNode;
        Node current = deletedNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != deletedNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deletedNode.rightChild;
        }
        return successor;
    }

    @Test
    void test01() {
        TwoFeatureTree tree = new TwoFeatureTree();
        Set<Integer> set = new HashSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("int values time: %sms\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        set.forEach(tree::add);
        endTime = System.currentTimeMillis();
        System.out.printf("tree add value time: %sms\n" , endTime - startTime);

        System.out.printf("treeSize: %s\n", tree.size);

        startTime = System.currentTimeMillis();
        tree.find(99999);
        endTime = System.currentTimeMillis();
        System.out.printf("find one data time: %sms\n", endTime - startTime);
    }

    @Test
    void test02() {

    }

}
