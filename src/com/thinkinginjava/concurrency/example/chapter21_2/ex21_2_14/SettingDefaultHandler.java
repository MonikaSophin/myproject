package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new OtherMyUncaughtExeptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        /**
         * 这里可以去测试默认的“未捕获异常处理器”和ThreadFactory设置的“未捕获异常处理器”的作用范围。
         * 结果可以下面的的结论。
         * //ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
         */
        exec.execute(new ExceptionThread2());
    }
}
/**输出：
 * run() by pool-1-thread-1
 * eh = java.lang.ThreadGroup[name=main,maxpri=10]
 * caught java.lang.RuntimeException
 *
 * 结论：
 *      可以按照具体情况逐个地设置“未捕获异常处理器”。如果你知道将要在代码中处处使用相同的“未捕获异常处理器”，
 *   那么更简单的方式是在Thread类中设置一个静态域，并将这个异常处理器设置为默认的“未捕获异常处理器”。
 *
 *      如果有默认的“未捕获异常处理器”和ThreadFactory设置的“未捕获异常处理器”共同作用下,
 *   默认的“未捕获异常处理器”将会失去作用。
 */