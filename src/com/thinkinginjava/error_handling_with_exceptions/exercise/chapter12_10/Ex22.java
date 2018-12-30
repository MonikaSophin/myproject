package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:25
 * @Version: 1.0
 * @Description: page 275
 * 练习22：创建一个名为FailingConstructor.java的类，它具有一个可能会在构造过程中失
 * 败并且会抛出一个异常的构造器。在main()中，编写能够确保不出现故障的代码。
 */
class FailingConstructor22 {
    Integer[] ia = new Integer[2];
    String s;
    FailingConstructor22(String s) throws Exception {
        ia[0] = 0;
        ia[1] = 1;
        ia[2] = 2;
        this.s = s;
    }
}

public class Ex22 {
    public static void main(String[] args) {
        try {
            FailingConstructor22 fc = new FailingConstructor22("hi");
        } catch(Exception e) {
            System.err.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        } finally {
            // ...
        }
    }
}
/**output:
 * Caught Exception in main()
 * java.lang.ArrayIndexOutOfBoundsException: 2
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.FailingConstructor.<init>(Ex22.java:17)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.Ex22.main(Ex22.java:25)
 */