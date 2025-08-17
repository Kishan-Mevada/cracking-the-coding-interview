package com.nk.linkedlist.base;

public class SinglyLinkedList {
    Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addFirst(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node currentHead = head;
            head = new Node(val);
            head.next = currentHead;
        }
    }

    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(val);
        }
    }

    public void addAt(int index, int val) {
        if (head == null) {
            throw new RuntimeException("Index does not exists");
        }
        int counter = 1;
        Node n = head;
        while (n.next != null && counter != index) {
            n = n.next;
            counter++;
        }

        if (counter == index) {
            Node temp = n.next;
            Node newNode = new Node(val);
            newNode.next = temp;
            n.next = newNode;
        } else {
            throw new RuntimeException("Index does not exists");
        }

    }

    public Node deleteFirst() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp;
        }
        return null;
    }

    public Node deleteLast() {
        if (head != null) {
            Node temp = head;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            Node lastNode = temp.next;
            temp.next = null;
            return lastNode;
        }
        return null;
    }

    public Node deleteAt(int index) {
        if (head != null) {
            int counter = 1;
            Node n = head;
            while (n.next != null && counter != index) {
                n = n.next;
                counter++;
            }

            if (counter == index) {
                if (n.next == null) {
                    return deleteLast();
                } else {
                    Node temp = n.next;
                    n.next = n.next.next;
                    return temp;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.val).append("->");
            temp = temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }
}
