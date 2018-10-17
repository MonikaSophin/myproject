package com.thinkinginjava.concurrency.example.ex21_2_3;

import com.thinkinginjava.concurrency.example.ex21_2_1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * page 656  缓存型线程池（在程序执行过程中通常会创建与所需数量相同的线程，
 *                      然后在它回收旧线程时停止创建新线程。
 *                      线程池的首选，但是处理高并发问题，使用FixedThreadPool）
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
/**
 * 输出：略
 */
