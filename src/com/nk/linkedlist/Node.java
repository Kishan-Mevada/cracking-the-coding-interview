package com.nk.linkedlist;

public class Node {
   Node prev;
   Node next;
   int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
