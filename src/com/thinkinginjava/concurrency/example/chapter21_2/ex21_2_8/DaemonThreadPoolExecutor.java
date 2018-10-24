package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

import java.util.concurrent.*;

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new DaemonThreadFactory());
    }
}
