package com.thinkinginjava.concurrency.example.chapter21_10;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/30
 * @description:
 */
public class ActiveObjectDemo {
    private ExecutorService exec =
            Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);
    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(
                    100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }
    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                print(String.format("starting %s + %s", x, y));
                pause(500);
                return x + y;
            }
        });
    }
    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                print(String.format("starting %s + %s", x, y));
                pause(2000);
                return x + y;
            }
        });
    }
    public void shutdown() { exec.shutdown(); }

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> results =
                new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f += 0.2f)
            results.add(d1.calculateFloat(f, f));
        for (int i = 0; i < 5; i++)
            results.add(d1.calculateInt(i, i));
        print("All asynch calls made");
        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        print(f.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    results.remove(f);
                }
            }
        }
        d1.shutdown();
    }
}
/**output(Sample):
 * All asynch calls made
 * starting 0.0 + 0.0
 * 0.0
 * starting 0.2 + 0.2
 * 0.4
 * starting 0.4 + 0.4
 * 0.8
 * starting 0.6 + 0.6
 * 1.2
 * starting 0.8 + 0.8
 * 1.6
 * starting 0 + 0
 * 0
 * starting 1 + 1
 * 2
 * starting 2 + 2
 * 4
 * starting 3 + 3
 * 6
 * starting 4 + 4
 * 8
 */