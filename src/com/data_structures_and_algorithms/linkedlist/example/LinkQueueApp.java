package com.data_structures_and_algorithms.linkedlist.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/23
 * @description: 清单5.5 用链表实现的队列
 */
class Link5 {
    public long dData;
    public Link5 next;
    public Link5(long dData) { this.dData = dData; }
    public void displayLink5() { System.out.print(dData + " "); }
}

class FirstLastList2 {
    private Link5 first;
    private Link5 last;
    public FirstLastList2() {
        first = null;
        last = null;
    }

    public boolean isEmpty() { return  first == null; }

    public void insertLast(long dd) {
        Link5 newLink = new Link5(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last)");
        Link5 current = first;
        while (current != null){
            current.displayLink5();
            current = current.next;
        }
        System.out.println();
    }
}

class LinkQueue {
    private FirstLastList2 theList;
    public LinkQueue() { theList = new FirstLastList2(); }

    public boolean isEmpty() { return theList.isEmpty(); }
    public void insert(long l) { theList.insertLast(l); }
    public void remove() { theList.deleteFirst(); }
    public void displayQueue() {
        System.out.print("Queue (front-->rear)");
        theList.displayList();
    }
}

public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);
        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);
        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();
        theQueue.displayQueue();
    }
}
/**output:
 * Queue (front-->rear)List (first-->last)20 40
 * Queue (front-->rear)List (first-->last)20 40 60 80
 * Queue (front-->rear)List (first-->last)60 80
 */