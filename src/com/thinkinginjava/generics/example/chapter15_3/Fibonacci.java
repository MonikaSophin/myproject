package com.thinkinginjava.generics.example.chapter15_3;

import com.thinkinginjava.util.Generator;

/**
 * @Author: monika
 * @Date: 2019/2/1 22:15
 * @Version: 1.0
 * @Description:
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;//实际操作的数字
    @Override
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}
/**output:
 * 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
 */