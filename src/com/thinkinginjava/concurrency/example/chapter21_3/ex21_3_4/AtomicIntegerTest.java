package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_4;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_3.AtomicityTest;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description: 使用了 {@link AtomicInteger} 重写了 {@link AtomicityTest}
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue() { return i.get(); }
    /**
     * 以原子方式将给定值添加到当前值
     */
    private void evenIncrement() {
        i.addAndGet(2);
    }
    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);//5秒后终止

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
/**output:
 * Aborting
 *
 * 注：使用AtomicInteger而消除synchronize关键字。因为这个程序不会失败，
 * 所以添加了一个Timer，以便在5秒钟之后自动地终止。
 */
