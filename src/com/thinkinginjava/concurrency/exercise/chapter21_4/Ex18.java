package com.thinkinginjava.concurrency.exercise.chapter21_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description: page 699
 * 练习18：创建一个非任务的类，它有一个用较长的时间间隔调用sleep()的方法。
 * 创建一个任务，它将调用这个非任务类上的那个方法。在main()中，启动该任务，
 * 然后调用interrupt()来终止它。请确保这个任务被安全地关闭。
 */
class NonTask {
    public void f() {
        try {
            print("start non-task method f()");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            print("NonTask InterruptedException");
        }
        print("Exiting NonTask.f() " + this);
    }
}

public class Ex18 {
    public static void main(String[] args) throws InterruptedException {
        final NonTask nonTask = new NonTask();
        Thread thread = new Thread(() -> { nonTask.f(); });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.isInterrupted();
    }
}
/**output(Sample):
 * start non-task method f()
 * Exiting NonTask.f() com.thinkinginjava.concurrency.exercise.chapter21_4.NonTask@2fd04fd1
 */