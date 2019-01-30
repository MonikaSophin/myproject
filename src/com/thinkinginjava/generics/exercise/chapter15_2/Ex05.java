package com.thinkinginjava.generics.exercise.chapter15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description: page 357
 * 练习05：移除Node类上的类型参数，并修改LinkedStack.java的代码，证明内部类可以访问
 * 外部类的类型参数。
 */
class LinkedStack<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        public Node() { this.item = null; this.next = null; }
        public Node(T item, Node<T> next) {
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
}

public class Ex05 {
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