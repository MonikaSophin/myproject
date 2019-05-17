package com.thinkinginjava.concurrency.exercise.chapter21_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/8
 * @description: page 706
 * 练习22：创建一个忙等待的示例。第一个任务休眠一段时间然后将一个标志设置为true，
 * 而第二个任务在一个while循环中观察这个标志（这就是忙等待），并且当该标志变为
 * true时，将其设置回false，然后向控制台报告这个变化。请注意程序在忙等待中浪费了
 * 多少时间，然后创建该程序的第二个版本，其中将使用wait()而不是忙等待。
 */
class Runnable1 implements Runnable {
    boolean flag = false;
    public synchronized void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e) {
            print("sleep interrupted in A");
        }
        print("Runnable1 setting flag = true");
        flag = true;
    }
}

class BusyWait implements Runnable {
    Runnable1 a = new Runnable1();
    long start, end;
    public synchronized Runnable1 getA() { return a; }
    private BusyWait(Runnable1 a) {
        this.a = a;
    }
    public static BusyWait buildBusyWait(Runnable1 a) {
        return new BusyWait(a);
    }
    public synchronized void run() {
        print("Busy a.flag = " + a.flag);
        while(!Thread.interrupted()) {
            start = System.nanoTime();
            if(a.flag) {
                a.flag = false;
                print("BusyWait reset a.flag = false");
                end = System.nanoTime();
                print("Busy waiting " + (end - start) + " nanoseconds");
            }
        }
    }
}

class BetterWait implements Runnable {
    private Runnable1 a = new Runnable1();
    public synchronized Runnable1 getA() { return a; }
    private BetterWait(Runnable1 a) {
        this.a = a;
    }
    public static BetterWait buildBetterWait(Runnable1 a) {
        return new BetterWait(a);
    }
    public synchronized void run() {
        print("Better a.flag = " + a.flag);
        try {
            while(!a.flag) {
                wait();
                a.flag = false;
                print("BetterWait reset a.flag = false");
            }
        } catch(InterruptedException e) {
            print("BetterWait.run() interrupted");
        }
    }
}

public class Ex22 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        BusyWait busy = BusyWait.buildBusyWait(new Runnable1());
        exec.execute(busy.a);
        exec.execute(busy);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            print("sleep interrupted in main()");
        }
        print();
        BetterWait better = BetterWait.buildBetterWait(new Runnable1());
        exec.execute(better.getA());
        exec.execute(better);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            print("sleep interrupted in main()");
        }
        synchronized(better) {
            print("Sending better.notifyAll()");
            better.notifyAll();
        }
        exec.shutdownNow();
    }
}
/**output:
 * Busy a.flag = false
 * Runnable1 setting flag = true
 * BusyWait reset a.flag = false
 * Busy waiting 97970 nanoseconds
 *
 * Better a.flag = false
 * Runnable1 setting flag = true
 * Sending better.notifyAll()
 * BetterWait reset a.flag = false
 * BetterWait.run() interrupted
 */