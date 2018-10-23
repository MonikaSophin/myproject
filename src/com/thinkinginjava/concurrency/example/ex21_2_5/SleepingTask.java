package com.thinkinginjava.concurrency.example.ex21_2_5;

import com.thinkinginjava.concurrency.example.ex21_2_1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run(){
        try{
            while(countDown-- >0){
                System.out.println(Thread.currentThread()+">> "+status());
                // Old-style
                // Thread.sleep(100); //Thread.sleep(long ms);参数的单元是毫秒
                // Java SE5/6-style
                TimeUnit.MILLISECONDS.sleep(100);//单元可指定
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
