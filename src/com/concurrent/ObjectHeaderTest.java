package com.concurrent;

import org.openjdk.jol.info.ClassLayout;

import java.nio.ByteOrder;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/10 11:18
 * @Version 1.0
 * @Description 测试对象的布局
 */
public class ObjectHeaderTest {

   /* static {
        Process exec = null;
        try {
            // 方法阻塞, 等待命令执行完成（成功会返回0）
            exec = Runtime.getRuntime().exec("java -version");
            exec.waitFor();
            System.out.println(IOUtils.toString(exec.getInputStream(), "utf-8"));
            System.out.println(IOUtils.toString(exec.getErrorStream(), "utf-8"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (exec != null) {
            exec.destroy();
        }
    }*/

    static {
        System.out.println(ByteOrder.nativeOrder().toString());
    }

    public static void main(String[] args) throws InterruptedException {
//        normal();
//        biased();
//        lightweightLocked();
//        heavyweightLocked();
//        gcMark();
    }

    //无锁状态 001
    private static void normal() {
        Example example = new Example();
        System.out.println(ClassLayout.parseInstance(example).toPrintable());

        int hashCode = System.identityHashCode(example);
        System.out.println("hashCode:" + Integer.toHexString(hashCode));
        System.out.println(ClassLayout.parseInstance(example).toPrintable());


        int[] ints = new int[3];
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());

        int intHashCode = System.identityHashCode(ints);
        System.out.println("int hashCode:" + Integer.toHexString(intHashCode));
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
    }

    //偏向锁状态 101
    private static void biased() throws InterruptedException {
        //-XX:BiasedLockingStartupDelay=0 取消延时加载偏向锁
        Thread.sleep(5000);
        Example example = new Example();
        synchronized (example) {
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
    }

    //轻量锁状态 000
    private static void lightweightLocked() throws InterruptedException {
        //-XX:BiasedLockingStartupDelay=0 取消延时加载偏向锁
        Thread.sleep(5000);
        Example example = new Example();

        Runnable runnable = () -> {
            synchronized (example) {
                System.out.println("current thread name --> " + Thread.currentThread().getName());
                System.out.println(ClassLayout.parseInstance(example).toPrintable());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");

        t1.start();
        t1.join();

        t2.start();
        t2.join();
    }

    //重量锁状态 010
    private static void heavyweightLocked() throws InterruptedException {
        //-XX:BiasedLockingStartupDelay=0 取消延时加载偏向锁
        Thread.sleep(5000);
        Example example = new Example();

        Runnable runnable = () -> {
            synchronized (example) {
                System.out.println("current thread name --> " + Thread.currentThread().getName());
                System.out.println(ClassLayout.parseInstance(example).toPrintable());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    // gc标记 011
    private static void gcMark() {
        Example example = new Example();
        System.gc();
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
