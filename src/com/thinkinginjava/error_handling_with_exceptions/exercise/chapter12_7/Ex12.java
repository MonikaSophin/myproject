package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_7;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:01
 * @Version: 1.0
 * @Description: page 264
 * 练习12：修改innerclasses/Sequence.java，使其在你试图向其中放置过多地元素时，
 * 抛出一个合适的异常。
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
        else
            throw new IndexOutOfBoundsException();
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 11; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
/**
 * Exception in thread "main" java.lang.IndexOutOfBoundsException
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_7.Sequence.add(Ex12.java:25)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_7.Ex12.main(Ex12.java:42)w2sss
 */