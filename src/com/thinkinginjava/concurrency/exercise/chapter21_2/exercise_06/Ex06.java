package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_06;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex06 implements Runnable {
    Random random = new Random();
    @Override
    public void run() {
        try {
            long sleepTime = random.nextInt(10)*1000;//unit :ms
            //Thread.sleep(sleepTime);//Thread.sleep(long ms);参数的单元是毫秒
            TimeUnit.MILLISECONDS.sleep(sleepTime);//单元可指定
            System.out.println(Thread.currentThread()+">> sleep  "+sleepTime/1000+"s");
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Ex06());
         exec.shutdown();
    }
}
