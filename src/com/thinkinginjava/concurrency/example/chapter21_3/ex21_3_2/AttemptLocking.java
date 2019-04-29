package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description:
 * Locks in the concurrent library allow you to give up on trying to acquire a lock.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock可用
        al.timed(); // True -- lock可用

        // 现在创建一个单独的任务来抓取lock
        new Thread() {
            {
                setDaemon(true);
            }
            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield(); //给第二个任务一个机会
        al.untimed(); // False -- lock被任务抓住了
        al.timed(); // False -- lock被任务抓住了
    }
}
/**output:
 * tryLock(): true
 * tryLock(2, TimeUnit.SECONDS): true
 * acquired
 * tryLock(): false
 * tryLock(2, TimeUnit.SECONDS): false
 */