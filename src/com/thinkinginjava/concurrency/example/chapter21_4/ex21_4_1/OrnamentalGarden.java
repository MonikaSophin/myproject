package com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description:
 */
class Count {
    private int count = 0;
    private Random rand = new Random(47);
    // 可以删除synchronized关键字以查看计数失败
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() { return count; }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    //不需要同步读取
    private final int id;
    private static volatile boolean canceled = false;
    // volatile上的原子操作
    public static void cancel() { canceled = true; }
    public Entrance(int id) {
        this.id = id;
        //将此任务保留在列表中。还可以防止垃圾收集或dead任务
        entrances.add(this);
    }

    @Override
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
    }
    public synchronized int getValue() { return number; }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}


public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++)
            exec.execute(new Entrance(i));
        //运行一段时间，main线程向Entrance发送static cancel信息，然后exec停止并收集数据,
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        /**
         * {@link ExecutorService#awaitTermination(long, TimeUnit)}:
         * 等待每个任务结束，如果所有的任务在超时时间达到之前全部结束，则返回true，
         * 否则返回false，表示不是所有的任务都已经结束了。
         */
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated!");
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
/**output(Sample):
 * Entrance 2: 1 Total: 1
 * Entrance 3: 1 Total: 2
 * Entrance 4: 1 Total: 3
 * Entrance 1: 1 Total: 4
 * Entrance 5: 1 Total: 5
 * ...
 * Entrance 1: 27 Total: 135
 * Entrance 4: 28 Total: 136
 * Entrance 2: 28 Total: 138
 * Entrance 3: 28 Total: 137
 * Entrance 1: 28 Total: 139
 * Entrance 5: 28 Total: 140
 * Stopping Entrance 3: 28
 * Stopping Entrance 4: 28
 * Stopping Entrance 2: 28
 * Stopping Entrance 1: 28
 * Stopping Entrance 5: 28
 * Total: 140
 * Sum of Entrances: 140
 */