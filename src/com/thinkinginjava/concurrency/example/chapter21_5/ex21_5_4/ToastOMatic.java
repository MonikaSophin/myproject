package com.thinkinginjava.concurrency.example.chapter21_5.ex21_5_4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/16
 * @description:
 */
class Toast {
    public enum Status { DRY, BUTTERED, JAMMED }
    private Status status = Status.DRY;
    private final int id;
    public Toast(int id) { this.id = id; }
    public void butter() { status = Status.BUTTERED; }
    public void jam() { status = Status.JAMMED; }
    public Status getStatus() { return status; }
    public int getId() { return id; }
    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}

//吐司
class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);
    public Toaster(ToastQueue toastQueue) { this.toastQueue = toastQueue; }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast t = new Toast(count++);
                print(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}

// 在吐司上涂黄油
class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQeue;
    public Butterer(ToastQueue dryQueue, ToastQueue butteredQeue) {
        this.dryQueue = dryQueue;
        this.butteredQeue = butteredQeue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.butter();
                print(t);
                butteredQeue.put(t);
            }
        } catch (InterruptedException e) {
            print("Butterer interrupted");
        }
        print("Butterer off");
    }
}

//  在抹过黄油的吐司上 涂果酱
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;
    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 直到下个吐司可用为止
                Toast t = butteredQueue.take();
                t.jam();
                print(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}

class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                //验证队列是否有序进行，并且要保证所有吐司要涂了果酱
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    print(">>> Error: " + t);
                    System.exit(1);
                } else {
                    print("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            print("Eater interrupted");
        }
        print("Eater off");
    }
}

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                   butteredQueue = new ToastQueue(),
                   finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
/**output(Sample):
 * Toast 0: DRY
 * Toast 0: BUTTERED
 * Toast 0: JAMMED
 * Chomp! Toast 0: JAMMED
 * Toast 1: DRY
 * Toast 1: BUTTERED
 * Toast 1: JAMMED
 * Chomp! Toast 1: JAMMED
 * Toast 2: DRY
 * Toast 2: BUTTERED
 * Toast 2: JAMMED
 * Chomp! Toast 2: JAMMED
 * Toast 3: DRY
 * Toast 3: BUTTERED
 * Toast 3: JAMMED
 * Chomp! Toast 3: JAMMED
 * Toast 4: DRY
 * Toast 4: BUTTERED
 * Toast 4: JAMMED
 * Chomp! Toast 4: JAMMED
 * Toast 5: DRY
 * Toast 5: BUTTERED
 * Toast 5: JAMMED
 * Chomp! Toast 5: JAMMED
 * Toast 6: DRY
 * Toast 6: BUTTERED
 * Toast 6: JAMMED
 * Chomp! Toast 6: JAMMED
 * Toast 7: DRY
 * Toast 7: BUTTERED
 * Toast 7: JAMMED
 * Chomp! Toast 7: JAMMED
 * Toast 8: DRY
 * Toast 8: BUTTERED
 * Toast 8: JAMMED
 * Chomp! Toast 8: JAMMED
 * Toast 9: DRY
 * Toast 9: BUTTERED
 * Toast 9: JAMMED
 * Chomp! Toast 9: JAMMED
 * Toast 10: DRY
 * Toast 10: BUTTERED
 * Toast 10: JAMMED
 * Chomp! Toast 10: JAMMED
 * Toast 11: DRY
 * Toast 11: BUTTERED
 * Toast 11: JAMMED
 * Chomp! Toast 11: JAMMED
 * Toast 12: DRY
 * Toast 12: BUTTERED
 * Toast 12: JAMMED
 * Chomp! Toast 12: JAMMED
 * Toast 13: DRY
 * Toast 13: BUTTERED
 * Toast 13: JAMMED
 * Chomp! Toast 13: JAMMED
 * Toaster interrupted
 * Toaster off
 * Butterer interrupted
 * Butterer off
 * Jammer interrupted
 * Jammer off
 * Eater interrupted
 * Eater off
 */