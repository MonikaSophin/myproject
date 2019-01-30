package com.thinkinginjava.generics.exercise.chapter15_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description: page 356
 * 练习04：“泛型化”innerclass/Sequence.java类。
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

class GenericSequence<E> {
    private List<E> list = new ArrayList<E>();
    private int next = 0;
    public GenericSequence(List<E> list) { this.list = list; }
    public void add(E e) { list.add(e); }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == list.size(); }
        public Object current() { return list.get(i); }
        public void next() { if(i < list.size()) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
}

public class Ex04 {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        GenericSequence<String> gs = new GenericSequence<>(ls);
        for(int i = 0; i < 10; i++)
            gs.add(Integer.toString(i));
        Selector selector = gs.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
/**output:
 * 0 1 2 3 4 5 6 7 8 9
 */