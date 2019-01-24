package com.data_structures_and_algorithms.linkedlist.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/17
 * @description: 清单5.1
 */
class Link {
    public int iData;//存储的数据
    public double dData;//存储的数据
    public Link next;//链表中下一个Link对象的引用

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink() { System.out.print("[" + iData + "," + dData +"] "); }
}

class LinkList {
    public Link first; //链表中第一个Link对象的引用
    public LinkList() { this.first = null; }
    public boolean isEmpty() { return first == null; }

    public void insertFirst(int id, double data) {
        Link newLink = new Link(id, data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first -> last): ");
        Link current = first;//链表中当前Link对象的引用
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList();

        while (!theList.isEmpty()) {
            Link link = theList.deleteFirst();
            System.out.print("Deleted ");
            link.displayLink();
            System.out.println();
        }
        theList.displayList();
        System.out.println("linkList isEmpty(): " + theList.isEmpty());
    }
}
/**output:
 * List (first -> last): [88,8.99] [66,6.99] [44,4.99] [22,2.99]
 * Deleted [88,8.99]
 * Deleted [66,6.99]
 * Deleted [44,4.99]
 * Deleted [22,2.99]
 * List (first -> last):
 * linkList isEmpty(): true
 */