package com.thinkinginjava.Initialize_clean.exercise.chapter5_5;

/**
 * @Author: monika
 * @Date: 2018/11/11 12:54
 * @Version: 1.0
 * @Description: page 89
 * 练习12：编写名为Tank的类。此类的状态可以是“满的”或“空的”。其终结条件是：
 * 对象被清理时必须处于空状态。请编写finalize()以验证终结条件是否成立。在main()中测试
 * Tank可能发生的几种使用方式。
 */
class Tank {
    int howFull = 0;
    String name;
    Tank(String name) {
        this(name, 0);
    }
    Tank(String name, int fullness) {
        howFull = fullness;
        this.name = name;
    }
    void sayHowFull() {
        if (howFull == 0) System.out.println(this.name + " is empty");
        else System.out.println(this.name + " filling status = " + howFull);
    }

    void empty() {
        howFull = 0;
    }

    protected void finalize() {
        if (howFull != 0)
            System.out.println("Error: "+ this.name +" not empty");
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Tank tank1 = new Tank("tank1");
        Tank tank2 = new Tank("tank2",3);
        Tank tank3 = new Tank("tank3",5);

        tank2.empty();
        // Drop the reference, forget to cleanup:
        new Tank("tank4",6);

        System.out.println("Check tanks:");
        System.out.println("tank1: ");
        tank1.sayHowFull();
        System.out.println("tank2: ");
        tank2.sayHowFull();
        System.out.println("tank3: ");
        tank3.sayHowFull();

        System.out.println("\nfirst forced gc():");
        System.gc();
        // Force finalization on exit but using method
        // deprecated since JDK 1.1:
        System.out.println("try deprecated runFinalizersOnExit(true):");
        System.runFinalizersOnExit(true);
        System.out.println("last forced gc():");
       // System.gc();
    }
}
