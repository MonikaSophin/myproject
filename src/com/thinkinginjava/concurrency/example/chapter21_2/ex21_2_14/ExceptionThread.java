package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        /**
         * 下面的任务总是会抛出一个异常，该异常会传播到run()方法的外部，
         * 并且想main()展示当你运行它时所发生的事情。
         */
        throw new RuntimeException();
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
