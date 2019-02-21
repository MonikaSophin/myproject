package com.thinkinginjava.generics.exercise.chapter15_3;

import com.thinkinginjava.util.Generator;
import java.util.Iterator;

/**
 * @Author: monika
 * @Date: 2019/2/1 22:29
 * @Version: 1.0
 * @Description: page 361
 * 练习07：使用组合代替继承，适配Fibonacci使其成为Iterable。
 */
class Fibonacci implements Generator<Integer>, Iterable<Integer> {
    private int n;//循环圈数
    private int count = 0;//实际操作的数字
    public Fibonacci(int n) { this.n = n; }
    @Override
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return n > 0; }
            @Override
            public Integer next() {
                n--;
                return Fibonacci.this.next();
            }
        };
    }
}

public class Ex07 {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(20);
        for (Integer integer : fibonacci) {
            System.out.print(integer + " ");
        }
    }
}
/**output:
 * 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
 */