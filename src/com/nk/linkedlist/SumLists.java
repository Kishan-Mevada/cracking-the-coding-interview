package com.nk.linkedlist;

public class SumLists {

    /**
     * Input: (7-1-6) + (5-9-2) -> 617+295
     * Output: 2-1-9 -> 912
     */
    public static SinglyLinkedList backwardSum(SinglyLinkedList ll1, SinglyLinkedList ll2) {
        int carry = 0;
        SinglyLinkedList output = new SinglyLinkedList();
        Node node1 = ll1.head;
        Node node2 = ll2.head;

        while (node1 != null && node2 != null) {
            int sum = carry + node1.val + node2.val;
            output.addLast(sum % 10);
            carry = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            int sum = carry + node1.val;
            output.addLast(sum % 10);
            carry = sum / 10;
            node1 = node1.next;
        }

        while (node2 != null) {
            int sum = carry + node2.val;
            output.addLast(sum % 10);
            carry = sum / 10;
            node2 = node2.next;
        }

        if(carry != 0 ) {
            output.addLast(carry);
        }

        return output;
    }

    /**
     * Input: (6-1-7) + (2-9-5) -> 617+295
     * Output: 9-1-2 -> 912
     */
    public static SinglyLinkedList forwardSum(SinglyLinkedList ll1, SinglyLinkedList ll2) {

        Node node1 = ll1.head;
        Node node2 = ll2.head;

        int val1 = 0;
        int val2 = 0;

        while(node1 != null) {
            val1 = (val1 * 10) + node1.val;
            node1 = node1.next;
        }

        while(node2 != null) {
            val2 = (val2 * 10) + node2.val;
            node2 = node2.next;
        }

        int sum = val1 + val2;
        SinglyLinkedList output = new SinglyLinkedList();
        while(sum > 0) {
            int rem = sum %10;
            output.addFirst(rem);
            sum = sum / 10;
        }

        return output;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();

        ll1.addLast(7);
        ll1.addLast(1);
        ll1.addLast(6);

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.addLast(5);
        ll2.addLast(9);
        ll2.addLast(2);

        System.out.println(" Backward Sum of Lists: " + backwardSum(ll1, ll2));

        SinglyLinkedList ll3 = new SinglyLinkedList();

        ll3.addLast(6);
        ll3.addLast(1);
        ll3.addLast(7);

        SinglyLinkedList ll4 = new SinglyLinkedList();
        ll4.addLast(2);
        ll4.addLast(9);
        ll4.addLast(5);

        System.out.println(" Forward Sum of Lists: " + forwardSum(ll3, ll4));
    }
}
