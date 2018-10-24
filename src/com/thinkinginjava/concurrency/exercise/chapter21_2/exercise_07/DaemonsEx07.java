package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_07;

public class DaemonsEx07 {
    public static void main(String[] args) throws InterruptedException {
        //后台线程派生的子线程为后台线程。(这些子线程并没有显式地被设置为后台线程)
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = "+d.isDaemon()+".");

        //注解main线程休眠时间(main方法结束，程序立即终止)
        // 结论 ：d线程(后台线程)所派生的子线程也不执行了，后台线程派生的子线程也是后台线程
        //TimeUnit.MILLISECONDS.sleep(2000);
    }
}
