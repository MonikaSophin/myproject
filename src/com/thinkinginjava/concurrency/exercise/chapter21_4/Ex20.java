package com.thinkinginjava.concurrency.exercise.chapter21_4;

import com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_3.CachedThreadPool;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description: page 699
 * 练习20：修改 {@link CachedThreadPool}，使所有任务在结束前都将收到一个interrupt()。
 */
public class Ex20 {

    /**
     *  {@linkplain ExecutorService#shutdownNow()}
     *
     *    将exec.shutdown(); 改为 exec.shutdownNow();即可。
     * 因为在Executor上调用shutdownNow()它将发送一个interrupt()
     * 调用给它启动的所有线程。
     */

}
