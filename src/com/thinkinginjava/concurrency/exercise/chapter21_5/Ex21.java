package com.thinkinginjava.concurrency.exercise.chapter21_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/8
 * @description: page 706
 * 练习21：创建两个Runnable，其中一个的run()的方法启动并调用wait()，而第二个类应该
 * 捕获第一个Runable对象的引用，其run()方法应该在一定的秒数之后，为第一个任务调用
 * notifyAll()，从而使得第一个任务可以显示一条信息。使用Executor来测试你的类。
 */
class A implements Runnable {
    private /*volatile*/ boolean signal = false;
    @Override
    public synchronized void run() { // 方法调用wait（）必须拥有监视器
        try {
            while(!signal) { 	// wait() should always
                // 在循环中使用
                print("A.run() wait()");
                // TimeUnit.MILLISECONDS.sleep(1000);
                wait();
                signal = true;
                print("A is done waiting");
            }
        } catch(InterruptedException e) {
            print("A run() interrupted");
        } finally {
            print("Leaving A.run()");
        }
    }
    public synchronized void message() {
        print("Hi from A");
    }
}

class B implements Runnable {
    private A a;
    public A getA() { return a; }
    B(A a) { this.a = a; }
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
            synchronized(a) { // 调用notifyAll（）的方法必须拥有监视器
                print("B.run() a.notifyAll()");
                a.notifyAll();
            }
        } catch(InterruptedException e) {
            System.out.println("B sleep interrupted");
        }
    }
}

public class Ex21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        B b = new B(new A());
        exec.execute(b.getA());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch(InterruptedException e) {
            System.out.println("main() sleep interrupted");
        }
        b.getA().message();
        exec.execute(b);
        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch(InterruptedException e) {
            System.out.println("main() sleep interrupted");
        }
        exec.shutdownNow();
    }
}
/**output:
 * A.run() wait()
 * Hi from A
 * B.run() a.notifyAll()
 * A is done waiting
 * Leaving A.run()
 */