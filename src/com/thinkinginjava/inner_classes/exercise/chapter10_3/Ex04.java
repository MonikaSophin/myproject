package com.thinkinginjava.inner_classes.exercise.chapter10_3;

/**
 * @Author: monika
 * @Date: 2018/11/29 22:05
 * @Version: 1.0
 * @Description: page 194
 * 练习04：在Sequence.SequenceSelector类中增加一个方法，
 * 它可以生成对外部类Sequence的引用。
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
    }
    public class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
        Sequence getSequence(){return Sequence.this;}
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        System.out.println(sequence);

        //若内部类被private修饰时，只能在本类中访问内部类。
        Selector selector = sequence.selector();
        Sequence sequence1 = ((SequenceSelector) selector).getSequence();
        System.out.println(sequence1);
    }
}

public class Ex04 {
    public static void main(String[] args) {
        System.out.println("在Ex04.main()中操作内部类：");
        Sequence sequence = new Sequence(10);
        System.out.println(sequence);

        //在Ex04中访问Sequence内部类的方法（该内部类要能被Ex04类访问到）
        Sequence.SequenceSelector sequenceSelector
                = sequence.new SequenceSelector();
        Sequence sequence1 = sequenceSelector.getSequence();
        System.out.println(sequence1);

        System.out.println("在外部类Sequence.main()中操作内部类：");
        Sequence.main(args);
    }
}
/**输出：
 * 在Ex04.main()中操作内部类：
 * com.thinkinginjava.inner_classes.exercise.chapter10_3.Sequence@4554617c
 * com.thinkinginjava.inner_classes.exercise.chapter10_3.Sequence@4554617c
 * 在外部类Sequence.main()中操作内部类：
 * com.thinkinginjava.inner_classes.exercise.chapter10_3.Sequence@74a14482
 * com.thinkinginjava.inner_classes.exercise.chapter10_3.Sequence@74a14482
 */