package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHanding {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
            /**
             * 由于线程的本质特性，使得你不能捕获从线程中逃逸的异常。
             * 一旦异常逃出任务的run()方法，它就会向外传播到控制台，除非你采用特性的步骤捕获这种错误的异常。
             */
        } catch (RuntimeException e) {//捕获不到 ExceptionThread中run()所抛出的异常。
            System.out.println("Exception has been handled");
        }
    }
}
