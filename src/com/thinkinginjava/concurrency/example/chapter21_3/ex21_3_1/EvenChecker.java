package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    public EvenChecker(IntGenerator g) {
        generator = g;
    }
    @Override
    public void run() {
        //generator,isCanceled=false;则进入
        while (!generator.isCanceled()){
            int val = generator.next();
            //如果不是偶数，则输出 not even,并退出程序。
            if (val % 2!=0){
                System.out.println(val + " not even!");
                generator.cancel();//cancels all EvenChecker
            }
        }
    }
    public static void test(IntGenerator gp,int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count ; i++)
            exec.execute(new EvenChecker(gp));
        exec.shutdown();
    }
    //默认执行10次
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
