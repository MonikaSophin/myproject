package com.concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author XueYing.Cao
 * @date 2020/5/11
 * 测试偏向锁
 */
public class ObjectHeaderTest_Biased {

    public static void main(String[] args) throws InterruptedException {
        //-XX:BiasedLockingStartupDelay=0 取消延时加载偏向锁
        Thread.sleep(5000);
        Example example = new Example();
        biasedObject(example);
    }

    // 只有一个线程时， synchronized 为标记该对象头为偏向锁
    private static void biasedObject(Example example) {
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
