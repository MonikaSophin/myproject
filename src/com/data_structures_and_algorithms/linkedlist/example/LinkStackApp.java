package com.data_structures_and_algorithms.linkedlist.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/23
 * @description: 清单5.4 用链表实现的栈
 */
class Link4 {
    public long dData;
    public Link4 next;
    public Link4(long dData) { this.dData = dData; }
    public void displayLink4() { System.out.print(dData + " "); }
}

class LinkList3 {
    private Link4 first;
    public LinkList3() { first = null; }

    public boolean isEmpty() { return  first == null; }

    public void insertFirst(long dd) {
       Link4 newLink = new Link4(dd);
       newLink.next = first;
       first = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last)");
        Link4 current = first;
        while (current != null){
            current.displayLink4();
            current = current.next;
        }
        System.out.println();
    }
}

class LinkStack {
    private LinkList3 theList;
    public LinkStack() { this.theList = new LinkList3(); }

    public void push(long l) { theList.insertFirst(l); }
    public void pop() { theList.deleteFirst(); }
    public void isEmpty() { theList.isEmpty(); }
    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}

public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(20);
        theStack.push(40);
        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);
        theStack.displayStack();

        theStack.pop();
        theStack.pop();
        theStack.displayStack();
    }
}
/**output:
 * Stack (top-->bottom): List (first-->last)40 20
 * Stack (top-->bottom): List (first-->last)80 60 40 20
 * Stack (top-->bottom): List (first-->last)40 20
 */