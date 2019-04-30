package com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_3;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description:
 */
class SleepBlocked implements Runnable {//可被interrupt的
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            print("SleepBlocked InterruptedException");
        }
        print("Exiting SleepBlocked.run() \n");
    }
}

class IOBlocked implements Runnable {//不可被interrupt的
    private InputStream in;
    public IOBlocked(InputStream in) { this.in = in; }

    @Override
    public void run() {
        try {
            print("Waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run() \n");
    }
}

class SynchronizedBlocked implements Runnable {//不可被interrupt的
    public synchronized void f() {
        while (true) //从不释放锁
            Thread.yield();
    }
    public SynchronizedBlocked() {
        new Thread(() -> { f(); }).start();
    }

    @Override
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run() \n");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        print("Interrupting " + r.getClass().getSimpleName());
        f.cancel(true);
        print("Interrupt sent to " + r.getClass().getSimpleName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0);
    }
}
/**output(Sample):
 * Interrupting SleepBlocked
 * Interrupt sent to SleepBlocked
 * SleepBlocked InterruptedException
 * Exiting SleepBlocked.run()
 *
 * Waiting for read()
 * Interrupting IOBlocked
 * Interrupt sent to IOBlocked
 * Trying to call f()
 * Interrupting SynchronizedBlocked
 * Interrupt sent to SynchronizedBlocked
 * Aborting with System.exit(0)
 *
 * 注:SleepBlocked是可中断的阻塞示例，而IOBlocked和SynchronizedBlocked是不可中断的阻塞示例。
 * 这个程序证明I/O和在synchronized块上的等待是不可中断的，通过浏览代码，你也可以预见到这一点，
 * 无论是I/O还是尝试调用synchronized方法，都不需要任何InterruptedException处理器。
 */