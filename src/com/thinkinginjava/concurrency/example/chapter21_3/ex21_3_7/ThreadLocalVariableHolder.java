package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_7;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description:
 */
class Accessor implements Runnable {
    private final int id;
    public Accessor(int id) { this.id = id; }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    @Override
    public String toString() {
        return String.format("#%s: %s", id, ThreadLocalVariableHolder.get());
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random random = new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };
    public static void increment() {
        value.set(value.get() + 1);
    }
    public static int get() { return value.get(); }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}
/**output(Sample):
 * #1: 6694
 * #2: 962
 * #1: 6695
 * #2: 963
 * #1: 6696
 * #0: 9259
 * #2: 964
 * #4: 1862
 * #1: 6697
 * #0: 9260
 * #0: 9261
 * #0: 9262
 * #0: 9263
 * #0: 9264
 * #0: 9265
 * #0: 9266
 * #0: 9267
 * #0: 9268
 * #0: 9269
 * #0: 9270
 * #0: 9271
 * #0: 9272
 * #0: 9273
 * #0: 9274
 * #0: 9275
 * #0: 9276
 * #0: 9277
 * #0: 9278
 * #3: 556
 * #1: 6698
 * #2: 965
 * #0: 9279
 * #4: 1863
 * #1: 6699
 * #3: 557
 * ...
 */