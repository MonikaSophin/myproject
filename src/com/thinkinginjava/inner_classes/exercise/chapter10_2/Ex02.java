package com.thinkinginjava.inner_classes.exercise.chapter10_2;

/**
 * @Author: monika
 * @Date: 2018/11/29 21:47
 * @Version: 1.0
 * @Description: page 192
 * 练习02：创建一个类，它持有一个String，并且有一个显示这个String的toString()方法。
 * 将你的新类的若干个对象添加到一个Sequence对象中，然后显示它们。
 */
class Word {
    private String word;
    public Word(String s) { word = s; }
    public String toString() { return word; }
}

interface Selector2 {
    boolean end();
    Object current();
    void next();
}
class Sequence2 {
    private Object[] items;
    private int next = 0;
    public Sequence2(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector2 {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    public Selector2 selector() {
        return new SequenceSelector();
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Sequence2 sequence = new Sequence2(10);
        for(int i = 0; i < 10; i++)
            sequence.add(new Word(Integer.toString(i)));
        Selector2 selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        Word w1 = new Word("Peace");
        Word w2 = new Word("Love");
        Word w3 = new Word("Easter");
        Sequence2 message = new Sequence2(3);
        message.add(w1);
        message.add(w2);
        message.add(w3);
        Selector2 sel = message.selector();
        while(!sel.end()) {
            System.out.print(sel.current() + " ");
            sel.next();
        }
    }
}
/**输出：
 * 0 1 2 3 4 5 6 7 8 9 Peace Love Easter
 */