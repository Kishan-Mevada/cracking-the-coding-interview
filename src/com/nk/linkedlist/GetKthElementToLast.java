package com.nk.linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class GetKthElementToLast {
    public static int getElement(int index, SinglyLinkedList ll) {
        int count = 0;
        Node fast = ll.head;

        // Move fast pointer to required distance (Kth)
        while (count < index && fast != null) {
            fast = fast.next;
            count++;
        }

        if (count == index) {
            if (fast.next == null) {
                return ll.head.val;
            } else {
                Node slow = ll.head;
                while (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow.val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.display();
        System.out.println("3rd element from last: " + getElement(3, ll));
        System.out.println("5th element from last: " + getElement(5, ll));
        System.out.println("1st element from last: " + getElement(1, ll));
        System.out.println("11 element from last: " + getElement(11, ll));

    }
}
