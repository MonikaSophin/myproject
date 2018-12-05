package com.monika.jdk8.new_features_for_java_classlibs.concurrency;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 */
public class Concurrency {
    /**
     * 在新增Stream机制与lambda的基础之上，在java.util.concurrent.ConcurrentHashMap中加入了
     * 一些新方法来支持聚集操作。同时也在java.util.concurrent.ForkJoinPool类中加入了一些新方法
     * 来支持共有资源池（common pool）（请查看我们关于Java 并发的免费课程）。
     *
     * 新增的java.util.concurrent.locks.StampedLock类提供一直基于容量的锁，这种锁有三个模型来
     * 控制读写操作（它被认为是不太有名的java.util.concurrent.locks.ReadWriteLock类的替代者）。
     *
     * 在java.util.concurrent.atomic包中还增加了下面这些类：
     *
     * DoubleAccumulator
     * DoubleAdder
     * LongAccumulator
     * LongAdder
     */
}
