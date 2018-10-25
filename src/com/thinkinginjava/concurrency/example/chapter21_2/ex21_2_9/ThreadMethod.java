package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

/**
 * A separate method to run some code as a task.
 * 作为任务运行一些代码的独立方法
 */
public class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;
    public ThreadMethod(String name) { this.name = name; }
    public void runTask(){
        if (t == null){
            t = new Thread(name){
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) return;
                            this.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
                @Override
                public String toString() {
                    return getName()+": "+countDown;
                }
            };
            t.start();
        }
    }

}
