package com.mycompany.dllists_stacks_queues;

class Node {
    public int data;
    public Node next;
    public Node previous;

    public Node(int initialData) {
        data = initialData;
        next = null;
        previous = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (currentNode == tail) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node successor = currentNode.next;
            newNode.next = successor;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            successor.previous = newNode;
        }
    }

    public void remove(Node currentNode) {
        Node successor = currentNode.next;
        Node predecessor = currentNode.previous;
        if (successor != null) successor.previous = predecessor;
        if (predecessor != null) predecessor.next = successor;
        if (currentNode == head) head = successor;
        if (currentNode == tail) tail = predecessor;
    }

    public Object[] toArray() {
        Object[] arr = new Object[this.getSize()];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (Integer.valueOf(current.data).equals(obj)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int sumLastMElements(int m) {
        int sum = 0;
        Node current = tail;
        int count = 0;
        while (current != null && count < m) {
            sum += current.data;
            current = current.previous;
            count++;
        }
        return sum;
    }

    private int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
