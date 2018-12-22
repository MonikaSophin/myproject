package com.thinkinginjava.holding_objects.example.chapter11_13.ex11_13_1;

import com.thinkinginjava.holding_objects.example.chapter11_13.IterableClass;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/22 19:32
 * @Version: 1.0
 * @Description:
 */
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed(){
        return () -> {
            return new Iterator<String>() {
                private int current = words.length - 1;
                @Override
                public boolean hasNext() { return current > -1; }
                @Override
                public String next() { return words[current--]; }
                @Override
                public void remove() { throw new UnsupportedOperationException(); }
            };
        };
    }

    public Iterable<String> randomized(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffied =
                        new ArrayList<>(Arrays.asList(words));
                //Collections.shuffle() : 随机排序List元素。
                Collections.shuffle(shuffied,new Random(47));
                return shuffied.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic.reversed())
            System.out.print(s + " ");
        System.out.println();

        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();

        for (String s : mic)
            System.out.print(s + " ");
        System.out.println();
    }
}
/**output：
 * banana-shaped. be to Earth the know we how is that And
 * is banana-shaped. Earth that how the be And we know to
 * And that is how we know the Earth to be banana-shaped.
 */