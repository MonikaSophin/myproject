package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        /**
         * 正常的执行完next()方法，返回的currentEvenValue应是一个偶数。
         *
         * 一个任务有可能在另一个任务执行第一个对currentEvenValue的递增操作之后，
         * 但是没有执行第二个对currentEvenValue的递增操作之前,调用next()方法。
         * 这将使这个值处于“不恰当”的状态。
         *
         * 有一点很重要，那就是要注意到递增程序自身也需要多个步骤，并且在递增过程中任务可能
         * 会被线程机制挂起--也就是说，在Java中，递增不是原子性的操作。因此，如果不保护任务，
         * 即使单一的递增也不是安全的。
         */
        ++currentEvenValue;//Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
