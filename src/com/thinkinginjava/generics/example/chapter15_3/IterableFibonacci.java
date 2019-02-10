package com.thinkinginjava.generics.example.chapter15_3;

import java.util.Iterator;

/**
 * @Author: monika
 * @Date: 2019/2/1 22:23
 * @Version: 1.0
 * @Description:
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n; //循环的圈数
    public IterableFibonacci(int n) { this.n = n; }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return n > 0; }
            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
/**output:
 * 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
 */