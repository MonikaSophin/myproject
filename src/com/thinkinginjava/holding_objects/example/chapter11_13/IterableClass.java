package com.thinkinginjava.holding_objects.example.chapter11_13;

import java.util.Iterator;

/**
 * @Author: monika
 * @Date: 2018/12/22 14:33
 * @Version: 1.0
 * @Description:
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped.").split(" ");
    @Override
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() { return index < words.length; }
            @Override
            public String next() { return words[index++]; }
            @Override
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass())
            System.out.print(s + " ");
    }
}
/**输出：
 * And that is how we know the Earth to be banana-shaped.
 */