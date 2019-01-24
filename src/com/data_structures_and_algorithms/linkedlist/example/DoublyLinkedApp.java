package com.data_structures_and_algorithms.linkedlist.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/24
 * @description: 清单5.7 双向链表
 */
class Link8 {
    public long dData;
    public Link8 next;
    public Link8 previous;
    public Link8(long l) { dData = l; }
    public void displayLink8() { System.out.print(dData + " "); }
}

class DoublyLinkedList {
    private Link8 first;
    private Link8 last;
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() { return first == null; }

    public void insertFirst(long dd) {
        Link8 newLink = new Link8(dd);
        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        Link8 newLink = new Link8(dd);
        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link8 deleteFirst() {
        Link8 temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Link8 deleteLast() {
        Link8 temp = null;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        Link8 current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        Link8 newLink = new Link8(dd);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        }else{
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = newLink;
        current.next = newLink;
        return true;
    }

    public Link8 deleteKey(long key) {
        Link8 current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return null;
        }
        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;
        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link8 current = first;
        while (current != null) {
            current.displayLink8();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link8 current = last;
        while (current != null) {
            current.displayLink8();
            current = current.previous;
        }
        System.out.println();
    }
}

public class DoublyLinkedApp {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);
        theList.displayForward();

        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);
        theList.displayForward();
    }
}
/**output:
 * List (first-->last): 66 44 22 11 33 55
 * List (last-->first): 55 33 11 22 44 66
 * List (first-->last): 44 22 33
 * List (first-->last): 44 22 77 33 88
 */