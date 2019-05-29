package com.thinkinginjava.concurrency.example.chapter21_7.ex21_7_6;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/28
 * @description:
 */
class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }
    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            print(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            print(this + "checking in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            // ~
        }
    }
    @Override
    public String toString() { return "CheckoutTask " + id + " "; }
}

public class SemaphoreDemo {
    final static int SIZE = 25;
    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++)
            exec.execute(new CheckoutTask<>(pool));
        print("All CheckoutTasks created");
        ArrayList<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            printnb(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = exec.submit(() -> {
            try {
                pool.checkOut();
            } catch (InterruptedException e) {
                print("checkOut() Interrupted");
            }
        });
        TimeUnit.SECONDS.sleep(2);
        // 打破被阻塞的call
        blocked.cancel(true);
        print("Checking in objects in " + list);
        for (Fat f : list)
            pool.checkIn(f);
        for (Fat f : list)
            pool.checkIn(f); // 第二个checkIn()被忽略
        exec.shutdownNow();
    }
}
/**output(Sample):
 * CheckoutTask 1 checked out Fat id: 1
 * CheckoutTask 3 checked out Fat id: 2
 * CheckoutTask 5 checked out Fat id: 3
 * CheckoutTask 0 checked out Fat id: 0
 * CheckoutTask 7 checked out Fat id: 4
 * CheckoutTask 4 checked out Fat id: 5
 * CheckoutTask 9 checked out Fat id: 6
 * CheckoutTask 8 checked out Fat id: 7
 * CheckoutTask 11 checked out Fat id: 8
 * CheckoutTask 12 checked out Fat id: 9
 * CheckoutTask 13 checked out Fat id: 10
 * CheckoutTask 2 checked out Fat id: 11
 * CheckoutTask 16 checked out Fat id: 12
 * CheckoutTask 15 checked out Fat id: 13
 * CheckoutTask 19 checked out Fat id: 14
 * CheckoutTask 6 checked out Fat id: 15
 * CheckoutTask 21 checked out Fat id: 16
 * CheckoutTask 10 checked out Fat id: 17
 * All CheckoutTasks created
 * CheckoutTask 14 checked out Fat id: 18
 * CheckoutTask 24 checked out Fat id: 20
 * CheckoutTask 18 checked out Fat id: 21
 * 0: main() thread checked out CheckoutTask 17 checked out Fat id: 22
 * Fat id: 19
 * CheckoutTask 22 checked out Fat id: 23
 * 1: main() thread checked out Fat id: 24
 * CheckoutTask 3 checking in Fat id: 2
 * CheckoutTask 9 checking in Fat id: 6
 * CheckoutTask 23 checked out Fat id: 2
 * CheckoutTask 7 checking in Fat id: 4
 * CheckoutTask 11 checking in Fat id: 8
 * CheckoutTask 5 checking in Fat id: 3
 * CheckoutTask 1 checking in Fat id: 1
 * CheckoutTask 13 checking in Fat id: 10
 * 2: main() thread checked out Fat id: 1
 * CheckoutTask 20 checked out Fat id: 3
 * 3: main() thread checked out Fat id: 4
 * 4: main() thread checked out Fat id: 6
 * 5: main() thread checked out Fat id: 8
 * 6: main() thread checked out Fat id: 10
 * CheckoutTask 0 checking in Fat id: 0
 * 7: main() thread checked out Fat id: 0
 * CheckoutTask 4 checking in Fat id: 5
 * 8: main() thread checked out Fat id: 5
 * CheckoutTask 21 checking in Fat id: 16
 * CheckoutTask 15 checking in Fat id: 13
 * CheckoutTask 19 checking in Fat id: 14
 * CheckoutTask 17 checking in Fat id: 22
 * 9: main() thread checked out Fat id: 13
 * 10: main() thread checked out Fat id: 14
 * 11: main() thread checked out Fat id: 16
 * 12: main() thread checked out Fat id: 22
 * CheckoutTask 8 checking in Fat id: 7
 * 13: main() thread checked out Fat id: 7
 * CheckoutTask 12 checking in Fat id: 9
 * 14: main() thread checked out Fat id: 9
 * CheckoutTask 16 checking in Fat id: 12
 * 15: main() thread checked out Fat id: 12
 * CheckoutTask 24 checking in Fat id: 20
 * 16: main() thread checked out Fat id: 20
 * CheckoutTask 2 checking in Fat id: 11
 * 17: main() thread checked out Fat id: 11
 * CheckoutTask 6 checking in Fat id: 15
 * 18: main() thread checked out Fat id: 15
 * CheckoutTask 14 checking in Fat id: 18
 * 19: main() thread checked out Fat id: 18
 * CheckoutTask 18 checking in Fat id: 21
 * 20: main() thread checked out Fat id: 21
 * CheckoutTask 22 checking in Fat id: 23
 * 21: main() thread checked out Fat id: 23
 * CheckoutTask 10 checking in Fat id: 17
 * 22: main() thread checked out Fat id: 17
 * CheckoutTask 20 checking in Fat id: 3
 * CheckoutTask 23 checking in Fat id: 2
 * 23: main() thread checked out Fat id: 3
 * 24: main() thread checked out Fat id: 2
 * checkOut() Interrupted
 * Checking in objects in [Fat id: 19, Fat id: 24, Fat id: 1, Fat id: 4, Fat id: 6, Fat id: 8, Fat id: 10, Fat id: 0, Fat id: 5, Fat id: 13, Fat id: 14, Fat id: 16, Fat id: 22, Fat id: 7, Fat id: 9, Fat id: 12, Fat id: 20, Fat id: 11, Fat id: 15, Fat id: 18, Fat id: 21, Fat id: 23, Fat id: 17, Fat id: 3, Fat id: 2]
 */