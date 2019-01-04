package com.data_structures_and_algorithms.stack_queue.exercise;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/3
 * @description: Page 129
 * 练习4.2： 根据本章里对双端队列的讨论编写一个Deque类。它应该包括insertLeft()、insertRight()、
 * removeLeft()、removeRight()、isEmpty()和isFull()方法。要求像队列那样支持在数据末端的回绕。
 */
class Deque<T> {
    private ArrayDeque<T> arrayDeque;
    public Deque() { arrayDeque = new ArrayDeque<>(); }

    public void insertLeft(T o){ arrayDeque.addFirst(o); }
    public void insertRight(T o){ arrayDeque.addLast(o); }
    public T removeLeft(){ return arrayDeque.removeFirst(); }
    public T removeRight(){ return arrayDeque.removeLast(); }
    public boolean isEmpty(){ return arrayDeque.isEmpty(); }
    public boolean isFull(){ return false; }
    public void displayDeque(){
        Iterator<T> iterator = arrayDeque.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}

public class Ex4_2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        System.out.println("insertLeft(): ");
        deque.displayDeque();
        System.out.println();

        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        System.out.println("insertRight(): ");
        deque.displayDeque();
        System.out.println();

        deque.removeLeft();
        deque.removeLeft();
        System.out.println("removeLeft(): ");
        deque.displayDeque();
        System.out.println();

        deque.removeRight();
        deque.removeRight();
        System.out.println("removeRight(): ");
        deque.displayDeque();
        System.out.println();

        System.out.println("isEmpty(): ");
        System.out.println(deque.isEmpty());
    }
}
