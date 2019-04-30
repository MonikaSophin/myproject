package com.thinkinginjava.concurrency.exercise.chapter21_4;

import com.thinkinginjava.concurrency.example.chapter21_4.ex21_4_1.OrnamentalGarden;

import java.util.concurrent.ExecutorService;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description: page 699
 * 练习19：修改 {@link OrnamentalGarden}，使其使用interrupt()。
 */
public class Ex19 {

    /**
     *  {@linkplain ExecutorService#shutdownNow()}
     *
     *    将exec.shutdown(); 改为 exec.shutdownNow();即可。
     * 因为在Executor上调用shutdownNow()它将发送一个interrupt()
     * 调用给它启动的所有线程。
     */

}
