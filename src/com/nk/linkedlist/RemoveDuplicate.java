package com.nk.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list without using temporary buffer.
 */
public class RemoveDuplicate {

    // Time: O(N*N), Space: (1)
    public static void removeDups(SinglyLinkedList ll) {
        Node temp = ll.head;

        while (temp != null) {
            int val = temp.val;
            Node temp1 = temp;
            while (temp1.next != null) {
                int val1 = temp1.next.val;
                if (val1 == val) {
                    temp1.next = temp1.next.next;
                    if (temp1.next == null) {
                        break;
                    }
                }
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
    }

    // Time: O(N), Space: (N)
    public static void removeDupUsingTempBuffer(SinglyLinkedList ll) {
        Node head = ll.head;
        if (head == null) return;
        Set<Integer> uniqueNumber = new HashSet<>();
        uniqueNumber.add(head.val);
        Node curr = head;

        while (curr.next != null) {
            if (!uniqueNumber.add(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Without temp buffer");
        SinglyLinkedList ll = new SinglyLinkedList();

        createDupValueLinkedList(ll);

        ll.display();
        removeDups(ll);
        ll.display();

        System.out.println("With Temp Buffer");
        SinglyLinkedList ll1 = new SinglyLinkedList();

        createDupValueLinkedList(ll1);

        ll1.display();
        removeDupUsingTempBuffer(ll1);
        ll1.display();
    }

    private static void createDupValueLinkedList(SinglyLinkedList ll) {
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(1);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(4);
    }
}
