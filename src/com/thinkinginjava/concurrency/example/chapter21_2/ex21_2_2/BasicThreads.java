package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_2;

import com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_1.LiftOff;

/**
 * page  655
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff(),"thread_01");
        t.start();
        System.out.println("Waiting fot Liftoff");
    }
}
/**
 * 输出:
 * Waiting fot Liftoff
 * thread_01>> #0[9].
 * thread_01>> #0[8].
 * thread_01>> #0[7].
 * thread_01>> #0[6].
 * thread_01>> #0[5].
 * thread_01>> #0[4].
 * thread_01>> #0[3].
 * thread_01>> #0[2].
 * thread_01>> #0[1].
 * thread_01>> #0[Liftoff!].
 */