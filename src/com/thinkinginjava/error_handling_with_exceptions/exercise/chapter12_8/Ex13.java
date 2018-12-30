package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:50
 * @Version: 1.0
 * @Description: page 267
 * 练习13：修改练习09，加一个finally子句。验证一下，即便是抛出NullPointException
 * 异常，finally子句也会得到执行。
 */
public class Ex13 {
    static void exception()  {
        System.out.println("Ex13#exception()");
        throw new NullPointerException("from Ex13#exception()");
    }

    public static void main(String[] args) {
        try {
            exception();
        } catch (Exception e) {
            System.out.println("Caught Exception:");
            e.printStackTrace(System.out);
        }finally {
            System.out.println("finally block run");
        }
    }
}
/**output:
 * Ex13#exception()
 * Caught Exception:
 * java.lang.NullPointerException: from Ex13#exception()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex13.exception(Ex13.java:14)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex13.main(Ex13.java:19)
 * finally block run
 */