package com.thinkinginjava.concurrency.example.chapter21_5.ex21_5_2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/9
 * @description:
 */
class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            // ok to exit
        }
    }
    synchronized void prod() { notify(); }
    synchronized void prodAll() { notifyAll(); }
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() { blocker.waitingCall(); }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() { blocker.waitingCall(); }
}

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Task());
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod) {
                    System.out.print("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nTimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        exec.shutdownNow();
    }
}
/**output(Sample):
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main]
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-5,5,main]
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main]
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-5,5,main]
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-5,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-3,5,main]
 * notify() Thread[pool-1-thread-1,5,main]
 * notifyAll() Thread[pool-1-thread-1,5,main] Thread[pool-1-thread-3,5,main] Thread[pool-1-thread-4,5,main] Thread[pool-1-thread-2,5,main] Thread[pool-1-thread-5,5,main]
 * Timer canceled
 * Task2.blocker.prodAll() Thread[pool-1-thread-6,5,main]
 * Shutting down
 */