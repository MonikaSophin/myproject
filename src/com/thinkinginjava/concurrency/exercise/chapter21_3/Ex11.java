package com.thinkinginjava.concurrency.exercise.chapter21_3;

import com.thinkinginjava.type_information.example.chapter14_9.A;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description: page 678
 * 练习11：创建一个类，它包含连个数据域和一个操作这些域的方法，其操作过程是多步骤的。
 * 这样在该方法执行过程中，这些域将处于“不正确地状态”（根据你舍得的某些定义）。添加
 * 读取这些域的方法，创建多个线程去调用各种方法，并展示处于“不正确状态的”数据是可视
 * 的。使用synchronized关键字修复这个问题。
 */
abstract class NumRangeGenerator { // non-task, non-Runnable, can be canceled
    private volatile boolean canceled = false;
    public abstract int[] next();
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}

class NumRangeChecker11 implements Runnable { // task(s) that depend on & share NumRangeGenerator
    private NumRangeGenerator generator;
    private final int id;
    public NumRangeChecker11(NumRangeGenerator g, int ident) {
        generator = g;
        id = ident;
    }
    @Override
    public void run() {
        System.out.println("Testing..");
        while (!generator.isCanceled()) {
            int[] range = generator.next();
            if (range[0] > range[1]) {
                System.out.println("Error in test #" + id + ": min " + range[0]
                        + " > " + "max " + range[1]);
                generator.cancel();
            }
        }
    }
    public static void test(NumRangeGenerator gen, int count) {
        System.out.println("Press Ctrl-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new NumRangeChecker11(gen, i));
        exec.shutdown();
    }
    public static void test(NumRangeGenerator gen) {
        test(gen, 10);
    }
}

class NumRangeGenerator11 extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random rand = new Random();
    @Override
    public int[] next() { // oops, method should be synchronized
        min = rand.nextInt(100);
        max = rand.nextInt(100);
        Thread.yield();
        if (min > max) max = min;
        int[] ia = {min, max};
        return ia;
    }

    public static void main(String[] args) {
        NumRangeChecker11.test(new NumRangeGenerator11());
    }
}

class SynchronizedNumRangeGenerator11 extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random rand = new Random();
    public synchronized int[] next() { // synchronized!
        min = rand.nextInt(100);
        max = rand.nextInt(100);
        Thread.yield();
        if (min > max) max = min;
        int[] ia = {min, max};
        return ia;
    }

    public static void main(String[] args) {
        NumRangeChecker11.test(new SynchronizedNumRangeGenerator11());
    }
}

public class Ex11 {
    public static void main(String[] args) {
        NumRangeGenerator11.main(args);
       // SynchronizedNumRangeGenerator11.main(args);
    }
}
