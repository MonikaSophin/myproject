package com.thinkinginjava.holding_objects.exercise.chapter11_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/11 22:14
 * @Version: 1.0
 * @Description: page 220
 * 练习03：修改innerclass/Sequence.java，使你可以向其中添加任意数量的元素。
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

class Sequence3 {
    private List<Object> items = new ArrayList<Object>();
    public void add(Object x) {
        items.add(x);
    }
    private class Sequence3Selector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.size();
        }
        public Object current() {
            return items.get(i);
        }
        public void next() {
            i++;
        }
    }
    public Selector selector() {
        return new Sequence3Selector();
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Sequence3 s3 = new Sequence3();
        for(int i = 0; i < 10; i++)
            s3.add(i);
        Selector selector = s3.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        s3.add(10);
        s3.add(11);
        s3.add(12);
        s3.add(13);
        s3.add(13);
        s3.add("good bye");
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
/**输出：
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 13 good bye
 */