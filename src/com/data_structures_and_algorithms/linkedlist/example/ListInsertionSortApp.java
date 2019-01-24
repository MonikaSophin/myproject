package com.data_structures_and_algorithms.linkedlist.example;

import sun.plugin.javascript.navig.LinkArray;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/23
 * @description: 清单5.7 使用链表实现一个简单排序
 */
class Link7 {
    public long dData;
    public Link7 next;
    public Link7(long dData) { this.dData = dData; }
    public void displayLink6() { System.out.print(dData + " "); }
}

class SortedList2 {
    private Link7 first;
    public SortedList2() { first = null; }

    public SortedList2(Link7[] linkArr) {
        first = null;
        for (int j = 0; j < linkArr.length; j++)
            insert(linkArr[j]);
    }

    private void insert(Link7 newLink) {
        Link7 previous = null;
        Link7 current = first;
        while (current != null && newLink.dData > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link7 remove() {
        Link7 temp = first;
        first = first.next;
        return temp;
    }
}

public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;
        Link7[] linkArray = new Link7[size];

        for (int j = 0; j < size; j++) {
            int n = (int) (Math.random()*99);
            Link7 newLink = new Link7(n);
            linkArray[j] = newLink;
        }

        System.out.println("Unsorted Array: ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println();

        SortedList2 theSortedList = new SortedList2(linkArray);
        for (int j = 0; j < size; j++)
            linkArray[j] = theSortedList.remove();
        System.out.println("Sorted Array: ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println();
    }
}
/**output(1% match):
 * Unsorted Array:
 * 23 16 55 49 16 97 71 86 94 65
 * Sorted Array:
 * 16 16 23 49 55 65 71 86 94 97
 */