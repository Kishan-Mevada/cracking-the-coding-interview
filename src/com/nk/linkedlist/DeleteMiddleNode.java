package com.nk.linkedlist;

/**
 * Implement an algorithm to delete a node in the middle of singly linked list
 */
public class DeleteMiddleNode {

    // Time: O(n), Space: O(1)
    public static Node deleteMiddleNode(SinglyLinkedList ll) {
        // return null if linked list empty
        if (ll.head == null) {
            return null;
        }
        // if linkedlist have only 1 element
        if (ll.head.next == null) {
            Node temp = ll.head;
            ll.head = null;
            return temp;
        }

        //Use slow and fast pointer to find middle element
        Node prev = null;
        Node slow = ll.head;
        Node fast = ll.head;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middleNode = slow;
        prev.next = slow.next;

        return middleNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.display();

        System.out.println("Middle Node -> " + deleteMiddleNode(ll));

        ll.display();

    }
}
