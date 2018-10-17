package com.thinkinginjava.concurrency.example.ex21_2_3;

import com.thinkinginjava.concurrency.example.ex21_2_1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * page 657   固定长度的线程池（一次性预先执行代价高昂的线程分配，因此也就可以限制线程的数量。
 *                          这可以节省时间，因为你不用为每个任务都固定地付出创建线程的开销。
 *                          高并发问题下，优先选择此线程池。）
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
/**
 * 输出：略
 */