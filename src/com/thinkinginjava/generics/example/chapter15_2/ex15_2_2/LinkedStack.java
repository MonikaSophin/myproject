package com.thinkinginjava.generics.example.chapter15_2.ex15_2_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        public Node() { this.item = null; this.next = null; }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() { return item == null && next == null; }
    }
    private Node<T> top = new Node<>();
    public void push(T item) {
        top = new Node<>(item, top);
    }
    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop())!= null)
            System.out.println(s);
    }
}
/**output:
 * stun!
 * on
 * Phasers
 */