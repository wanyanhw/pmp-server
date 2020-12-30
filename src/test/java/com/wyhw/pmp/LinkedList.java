package com.wyhw.pmp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 链表操作
 */
public class LinkedList<E> {

    private Node<E> first;

    public LinkedList() {
        this.first = null;
    }

    class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E e) {
            this.data = e;
        }

        public void displayNode() {
            System.out.printf("{" + this.data + "}");
        }
    }

    public void addFirst(E e) {
        Node newElement = new Node(e);
        newElement.next = first;
        first = newElement;
    }

    public Node<E> deleteFirst() {
        Node<E> tempNode = first;
        first = first.next;
        return tempNode;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void display() {
        Node<E> currentNode = first;
        while (currentNode != null) {
            currentNode.displayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    @Test
    public void test01() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst("我的一生");
        linkedList.addFirst(40);
        linkedList.display();
    }

}
