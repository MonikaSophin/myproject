package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

/**
 * 自管理的Runnable :在Runnable内部包含着它自己的驱动线程
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelfManaged() {
        t.start();
    }
    @Override
    public String toString() {
        return "#"+Thread.currentThread().getName()+"  ("+countDown+"),";
    }
    @Override
    public void run() {
        while(true){
            System.out.println(this);
            if (--countDown ==0)
                return;
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
