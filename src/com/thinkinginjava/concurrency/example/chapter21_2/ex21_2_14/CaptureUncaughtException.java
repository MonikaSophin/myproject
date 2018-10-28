package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * capture ; 捕获
 * caught : 抓住
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec
                = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
/**输出：
 * HandlerThreadFactory creating new Thread
 * created Thread-0
 * eh = com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14.MyUncaughtExceptionHandler@677327b6
 * run() by Thread-0
 * eh = com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14.MyUncaughtExceptionHandler@677327b6
 * HandlerThreadFactory creating new Thread
 * created Thread-1
 * eh = com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14.MyUncaughtExceptionHandler@72f5c249
 * caught java.lang.RuntimeException
 *
 * 推论：
 *   当任务中的run()出现异常逃逸时，上面设置的异常处理器会起作用。
 * 会让含有异常处理器的ThreadFactory再给一个线程去处理该异常。
 */
