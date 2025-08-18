package com.nk.linkedlist;

/**
 * Write code to partition a linked around a value X, such that all nodes less than x come before all nodes greater than or equal to X.
 * <p>
 * Example:
 * <p>
 * Input: 3-5-8-5-10-2-1
 * Output: 3-1-2-10-5-5-8
 */
public class PartitionLinkedList {

    public static void partitionBy(SinglyLinkedList ll, int pivot) {
        if (ll.head == null) return;
        //Dummy Node
        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        //Pointers
        Node lessThanPivot = lessHead;
        Node greaterThanPivot = greaterHead;

        Node current = ll.head;

        while(current != null) {
            if(current.val < pivot) {
                lessThanPivot.next = current;
                lessThanPivot = lessThanPivot.next;
            }
            else{
                greaterThanPivot.next = current;
                greaterThanPivot = greaterThanPivot.next;
            }
            current = current.next;
        }

        //Merge
        greaterThanPivot.next = null;

        lessThanPivot.next = greaterHead.next;

        ll.head = lessHead.next;

    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(8);
        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(2);
        ll.addLast(1);

        ll.display();

        partitionBy(ll, 5);

        ll.display();
    }
}
