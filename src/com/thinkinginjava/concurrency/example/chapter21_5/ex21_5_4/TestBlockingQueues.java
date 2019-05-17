package com.thinkinginjava.concurrency.example.chapter21_5.ex21_5_4;

import com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_1.LiftOff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/16
 * @description:
 */
class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
           print("Interrupted during put()");
        }
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            print("Waking from take()");
        }
        print("Exiting LiftRunner");
    }
}

public class TestBlockingQueues {
    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getKey(String message) {
        print(message);
        getKey();
    }
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getKey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        print("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>()); // size:不限
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3)); // size:3
        test("SynchronousQueue", new SynchronousQueue<>());// size:1
    }
}
/**output(Sample):
 * LinkedBlockingQueue
 * Press 'Enter' (LinkedBlockingQueue)
 * Thread-0>> #0[4].
 * Thread-0>> #0[3].
 * Thread-0>> #0[2].
 * Thread-0>> #0[1].
 * Thread-0>> #0[Liftoff!].
 * Thread-0>> #1[4].
 * Thread-0>> #1[3].
 * Thread-0>> #1[2].
 * Thread-0>> #1[1].
 * Thread-0>> #1[Liftoff!].
 * Thread-0>> #2[4].
 * Thread-0>> #2[3].
 * Thread-0>> #2[2].
 * Thread-0>> #2[1].
 * Thread-0>> #2[Liftoff!].
 * Thread-0>> #3[4].
 * Thread-0>> #3[3].
 * Thread-0>> #3[2].
 * Thread-0>> #3[1].
 * Thread-0>> #3[Liftoff!].
 * Thread-0>> #4[4].
 * Thread-0>> #4[3].
 * Thread-0>> #4[2].
 * Thread-0>> #4[1].
 * Thread-0>> #4[Liftoff!].
 * Finished LinkedBlockingQueue test
 * Waking from take()
 * Exiting LiftRunner
 *
 * ArrayBlockingQueue
 * Thread-1>> #5[4].
 * Thread-1>> #5[3].
 * Thread-1>> #5[2].
 * Thread-1>> #5[1].
 * Thread-1>> #5[Liftoff!].
 * Thread-1>> #6[4].
 * Press 'Enter' (ArrayBlockingQueue)
 * Thread-1>> #6[3].
 * Thread-1>> #6[2].
 * Thread-1>> #6[1].
 * Thread-1>> #6[Liftoff!].
 * Thread-1>> #7[4].
 * Thread-1>> #7[3].
 * Thread-1>> #7[2].
 * Thread-1>> #7[1].
 * Thread-1>> #7[Liftoff!].
 * Thread-1>> #8[4].
 * Thread-1>> #8[3].
 * Thread-1>> #8[2].
 * Thread-1>> #8[1].
 * Thread-1>> #8[Liftoff!].
 * Thread-1>> #9[4].
 * Thread-1>> #9[3].
 * Thread-1>> #9[2].
 * Thread-1>> #9[1].
 * Thread-1>> #9[Liftoff!].
 * Finished ArrayBlockingQueue test
 * Waking from take()
 * Exiting LiftRunner
 *
 * SynchronousQueue
 * Thread-2>> #10[4].
 * Thread-2>> #10[3].
 * Thread-2>> #10[2].
 * Thread-2>> #10[1].
 * Thread-2>> #10[Liftoff!].
 * Thread-2>> #11[4].
 * Thread-2>> #11[3].
 * Thread-2>> #11[2].
 * Thread-2>> #11[1].
 * Thread-2>> #11[Liftoff!].
 * Thread-2>> #12[4].
 * Thread-2>> #12[3].
 * Thread-2>> #12[2].
 * Thread-2>> #12[1].
 * Thread-2>> #12[Liftoff!].
 * Thread-2>> #13[4].
 * Thread-2>> #13[3].
 * Thread-2>> #13[2].
 * Thread-2>> #13[1].
 * Thread-2>> #13[Liftoff!].
 * Press 'Enter' (SynchronousQueue)
 * Thread-2>> #14[4].
 * Thread-2>> #14[3].
 * Thread-2>> #14[2].
 * Thread-2>> #14[1].
 * Thread-2>> #14[Liftoff!].
 * Finished SynchronousQueue test
 * Waking from take()
 * Exiting LiftRunner
 */