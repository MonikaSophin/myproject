package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:36
 * @Version: 1.0
 * @Description: page 253
 * 练习05：使用while循环建立类似“恢复模型”的异常处理行为，它将不断重复，直到
 * 异常不再抛出。
 */
public class Ex05 {
    private static int[] ia = new int[3];
    static int x = 5;
    public static void main(String[] args) {
        while(true) {
            try {
                ia[x] = 1;
                System.out.println(ia[x]);
                break;
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println(
                        "Caught ArrayIndexOutOfBoundsException: " + x);
                x--;
            } finally {
                System.out.println("Are we done yet? x=" + x);
            }
        }
        System.out.println("Now, we're done.");
    }
}
/**output:
 * Caught ArrayIndexOutOfBoundsException: 5
 * Are we done yet? x=4
 * Caught ArrayIndexOutOfBoundsException: 4
 * Are we done yet? x=3
 * Caught ArrayIndexOutOfBoundsException: 3
 * Are we done yet? x=2
 * 1
 * Are we done yet? x=2
 * Now, we're done.
 */