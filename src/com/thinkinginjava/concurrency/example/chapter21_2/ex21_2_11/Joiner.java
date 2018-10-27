package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_11;

public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    @Override
    public void run() {
        try {
            /**
             * 本线程joiner和另一目标线程sleeper。
             * 在本线程joiner中调用sleeper.join();本线程joiner会被挂起，
             * 此时本线程joiner的isAlive会返回false。
             * 直到目标线程sleeper正常结束或是被中断之后本线程joiner才会恢复，
             * 此时本线程joiner的isAlive()会返回true。
             * 此时本线程joiner也加入目标线程sleeper成功。
             */
            sleeper.join();
            System.out.println(getName()+" isAlive() = "+isAlive());
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+" join completed");
    }
}
