package com.data_structures_and_algorithms.linkedlist.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/23
 * @description: 清单5.6 有序链表
 */
class Link6 {
    public long dData;
    public Link6 next;
    public Link6(long dData) { this.dData = dData; }
    public void displayLink6() { System.out.print(dData + " "); }
}

class SortedList {
    private Link6 first;
    public SortedList() { first = null; }

    public boolean isEmpty() { return first == null; }
    public void insert(long key) {
        Link6 newLink = new Link6(key);
        Link6 previous = null;
        Link6 current = first;
        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link6 remove() {
        Link6 temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link6 current = first;
        while (current != null){
            current.displayLink6();
            current = current.next;
        }
        System.out.println();
    }
}

public class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();

        theSortedList.insert(20);
        theSortedList.insert(40);
        theSortedList.displayList();

        theSortedList.insert(10);
        theSortedList.insert(30);
        theSortedList.insert(50);
        theSortedList.displayList();

        theSortedList.remove();
        theSortedList.remove();
        theSortedList.displayList();
    }
}
/**output:
 * List (first-->last): 20 40
 * List (first-->last): 10 20 30 40 50
 * List (first-->last): 30 40 50
 */