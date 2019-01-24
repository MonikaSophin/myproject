package com.data_structures_and_algorithms.linkedlist.example;

import java.lang.annotation.Target;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/18
 * @description: 清单5.2
 */
class Link2 {
    public int iData;
    public double dData;
    public Link2 next;
    public Link2(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink() { System.out.print("[" + iData + "," + dData + "]"); }
}

class LinkList2 {
    private Link2 first;
    public LinkList2() { first = null; }

    public void insertFirst(int id, double data) {
        Link2 newLink = new Link2(id, data);
        newLink.next = first;
        first = newLink;
    }

    public Link2 deleteFirst() {
        Link2 temp = first;
        first = first.next;
        return temp;
    }

    public Link2 find(int key) {
        Link2 current = first;
        while (current.iData != key) {
            current = current.next != null ? current.next : null;
        }
        return current;
    }

    public Link2 delete(int key) {
        Link2 current = first;
        Link2 previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else {//到下一个链接点
                previous = current;
                current = current.next;
            }
            //删除包含key的链接点
            if (current == first)
                first = first.next;
            else
                previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.print("List (first -> last): ");
        Link2 current = first;//链表中当前Link对象的引用
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

public class LinkList2App {
    public static void main(String[] args) {
        LinkList2 theList = new LinkList2();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList();

        Link2 f = theList.find(44);
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link2 d = theList.delete(66);
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");
        theList.displayList();
    }
}
/**output:
 * List (first -> last): [88,8.99][66,6.99][44,4.99][22,2.99]
 * Found link with key 44
 * Deleted link with key 66
 * List (first -> last): [88,8.99][44,4.99][22,2.99]
 */