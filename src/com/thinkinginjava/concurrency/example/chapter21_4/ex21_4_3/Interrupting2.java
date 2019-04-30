package com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description:
 */
class BlockedMutex {
    private Lock lock = new ReentrantLock();
    public BlockedMutex() {
        // 立即获取它，以证明在ReentrantLock上阻止的任务的中断:
        lock.lock();
    }
    public void f() {
        try {
            // 这将永远不可用于第二项任务
            lock.lockInterruptibly(); // Special call
            print("lock acquired in f()");
        } catch(InterruptedException e) {
            print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();
    @Override
    public void run() {
        print("Waiting for f() in BlockedMutex");
        blocked.f();
        print("Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        print("Issuing t.interrupt()");
        t.interrupt();
    }
}
/**output:
 * Waiting for f() in BlockedMutex
 * Issuing t.interrupt()
 * Interrupted from lock acquisition in f()
 * Broken out of blocked call
 */