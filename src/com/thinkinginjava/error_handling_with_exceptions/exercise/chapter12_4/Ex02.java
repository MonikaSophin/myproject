package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:25
 * @Version: 1.0
 * @Description: page 253
 * 练习02：定义一个对象引用并初始化为null，尝试用此引用调用方法。把这个调用放在
 * try-catch子句里以捕获异常。
 */
public class Ex02 {
    public static void main(String[] args) {
        String s = null;
        try {
            s.toString();
        } catch (NullPointerException e) {
            e.printStackTrace(System.out);
        }
    }
}
/**output:
 * java.lang.NullPointerException
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.Ex02.main(Ex02.java:15)
 */