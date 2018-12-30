package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12;

/**
 * @Author: monika
 * @Date: 2018/12/30 17:34
 * @Version: 1.0
 * @Description: page 281
 * 练习27：修改练习03，将异常转变为RuntimeException。
 */
public class Ex27 {
    static void throwRuntimeException() {
        int[] ints = new int[3];
        try {
            ints[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            throwRuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * java.lang.RuntimeException: java.lang.ArrayIndexOutOfBoundsException: 5
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Ex27.throwRuntimeException(Ex27.java:16)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Ex27.main(Ex27.java:22)
 * Caused by: java.lang.ArrayIndexOutOfBoundsException: 5
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Ex27.throwRuntimeException(Ex27.java:14)
 * 	... 1 more
 */