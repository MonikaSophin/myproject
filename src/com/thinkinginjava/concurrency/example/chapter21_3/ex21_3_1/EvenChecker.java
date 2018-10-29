package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    public EvenChecker(IntGenerator g) {
        generator = g;
    }
    /**
     * 两个或更多的任务竞争响应某个条件，因此产生冲突或不一致结果的情况。
     * 所以必须仔细考虑并防范并发系统失败的所有可能途径，
     * 例如，一个任务不能依赖另一个任务，因为任务关闭的顺序无法得到保证。
     * 这里通过使任务依赖于非任务对象，这样可以消除潜在的竞争条件。
     */
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
