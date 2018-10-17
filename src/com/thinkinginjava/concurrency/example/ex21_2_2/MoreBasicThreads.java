package com.thinkinginjava.concurrency.example.ex21_2_2;

import com.thinkinginjava.concurrency.example.ex21_2_1.LiftOff;

/**
 * page 655
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for (int i = 0; i < 5;i++)
            new Thread(new LiftOff(),"thread_01").start();
        System.out.println("Waiting fot Liftoff");
    }
}
/**
 * 输出：略
 */