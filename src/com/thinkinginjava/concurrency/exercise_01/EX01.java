package com.thinkinginjava.concurrency.exercise_01;

/**
 * page 656
 *  练习1：实现一个Runnable。在run()内部打印一个信息，然后调用yield()。
 *    重复这个动作3次，然后从run()中返回。在构造器中放置一条启动信息，并放置一条在任务终止时的关闭信息。
 *    使用线程创建大量的这种任务并驱动他们。
 */
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


public class EX01 {
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