package com.thinkinginjava.concurrency.example.ex21_2_3;

import com.thinkinginjava.concurrency.example.ex21_2_1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * page 658  单线程池（同步的）
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
