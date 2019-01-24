package com.data_structures_and_algorithms.linkedlist.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/24
 * @description: 清单5.9 迭代器
 */
class Link9 {
    public long dData;
    public Link9 next;
    public Link9(long dd) { dData = dd; }
    public void displayLink9() { System.out.print(dData + " "); }
}

class LinkList4 {
    private Link9 first;
    public LinkList4() { first = null; }
    public Link9 getFirst() { return first; }
    public void setFirst(Link9 first) { this.first = first; }
    public boolean isEmpty() { return first == null; }
    public ListIterator getIterator() { return new ListIterator(this); }
    public void displayList4() {
        Link9 current = first;
        while (current != null) {
            current.displayLink9();
            current = current.next;
        }
        System.out.println();
    }
}

class ListIterator {
    private Link9 current;
    private Link9 previous;
    private LinkList4 ourList;
    public ListIterator(LinkList4 linkList4) {
        ourList = linkList4;
        reset();
    }
    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }
    public boolean atEnd() { return current.next == null; }
    public void nextLink() {
        previous = current;
        current = current.next;
    }
    public Link9 getCurrent() { return current; }
    public void insertAfter(long dd) {
        Link9 newLink = new Link9(dd);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        }else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }
    public void insertBefore(long dd) {
        Link9 newLink = new Link9(dd);
        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        }else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }
    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        }else {
            previous.next = current.next;
            if (atEnd()) reset();
            else current = current.next;
        }
        return value;
    }
}

public class InterIterApp {
    public static void main(String[] args) throws IOException {
        LinkList4 theList = new LinkList4();
        ListIterator iter1 = theList.getIterator();
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(60);
        iter1.insertAfter(80);

        while (true) {
            System.out.print("Enter first letter of show, reset, next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's' :
                    if (!theList.isEmpty())
                        theList.displayList4();
                    else
                        System.out.println("List is empty");
                    break;
                case 'r' :
                    iter1.reset();
                    break;
                case 'n' :
                    if (!theList.isEmpty() && !iter1.atEnd())
                        iter1.nextLink();
                    else
                        System.out.println("Can't go to next link");
                    break;
                case 'g' :
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    }else
                        System.out.println("List is Empty");
                    break;
                case 'b' :
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a' :
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd' :
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    }else
                        System.out.println("Can't delete");
                    break;
                default :
                    System.out.println("invalid entry");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
/**output:
 * Enter first letter of show, reset, next, get, before, after, delete: s
 * 20 40 60 80
 * Enter first letter of show, reset, next, get, before, after, delete: r
 * Enter first letter of show, reset, next, get, before, after, delete: n
 * Enter first letter of show, reset, next, get, before, after, delete: n
 * Enter first letter of show, reset, next, get, before, after, delete: g
 * Returned 60
 * Enter first letter of show, reset, next, get, before, after, delete: b
 * Enter value to insert: 100
 * Enter first letter of show, reset, next, get, before, after, delete: a
 * Enter value to insert: 7
 * Enter first letter of show, reset, next, get, before, after, delete: s
 * 20 40 100 7 60 80
 * Enter first letter of show, reset, next, get, before, after, delete:
 */