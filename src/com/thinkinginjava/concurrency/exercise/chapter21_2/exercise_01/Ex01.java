package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_01;

class RunnableA implements Runnable{
    public RunnableA(){
        System.out.println(Thread.currentThread().getName()+" >> A init");
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" >> A start");
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+" >> A running");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" >> A end");
        return;
    }
}
class RunnableB implements Runnable{
    public RunnableB(){
        System.out.println(Thread.currentThread().getName()+" >> B init");
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" >> B start");
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+" >> B running");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" >> B end");
        return;
    }
}


public class Ex01 {
    public static void main(String[] args){
        new Thread(new RunnableA(),"thread_01").start();
        new Thread(new RunnableA(),"thread_02").start();
        new Thread(new RunnableA(),"thread_03").start();

        new Thread(new RunnableB(),"thread_04").start();
        new Thread(new RunnableB(),"thread_05").start();
        new Thread(new RunnableB(),"thread_06").start();
    }
}
/**
 * 执行结果变化较大  yield()-->做出线程让步,使线程状态由运行变为就绪。
 *               把自己的CPU执行时间让出来，让给自己或其他线程去执行。
 *               优先级高的线程不是一定会执行到的，也有可能低优先级的线程会执行，只是优先级高的线程概率大。
 */
