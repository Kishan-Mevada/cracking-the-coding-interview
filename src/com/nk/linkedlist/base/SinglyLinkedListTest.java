package com.nk.linkedlist.base;

public class SinglyLinkedListTest {

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addAt(1, 11);

        ll.display();

        ll.addFirst(0);

        ll.display();

       // ll.addAt(11,12);

        ll.deleteFirst();

        ll.display();

        ll.deleteAt(3);

        ll.display();

        ll.deleteLast();

        ll.display();
    }
}
