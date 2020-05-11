package com.concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/10 11:18
 * @Version 1.0
 * @Description 测试对象的布局
 */
public class ObjectHeaderTest_Normal {

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

    public static void main(String[] args) throws InterruptedException {
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

    private static void lightweightLocked(Example example) {
        //        Runnable runnable = () -> heavyweightLocked(example);
//        Thread t1 = new Thread(runnable, "t1");
//        Thread t2 = new Thread(runnable, "t2");
//
//        t1.start();
//        t2.start();
        System.out.println("Lightweight locked --> " + Thread.currentThread().getName());
        synchronized (example) {
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
    }

    private static void heavyweightLocked(Example example) {
        System.out.println("Heavyweight locked --> " + Thread.currentThread().getName());
        synchronized (example) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
    }
}
