package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6;

/**
 * @Author: monika
 * @Date: 2018/12/27 21:48
 * @Version: 1.0
 * @Description: page 257
 * 练习09：定义三种新的异常类型。写一个类，在一个方法中抛出这三种异常。在main()
 * 里调用这个方法，仅用一个catch子句捕获这三种异常。
 */
class MyException1 extends Exception {
    public MyException1(String message) { super(message); }
}

class MyException2 extends Exception {
    public MyException2(String message) { super(message); }
}

class MyException3 extends Exception {
    public MyException3(String message) { super(message); }
}

public class Ex09 {
    static void exception(int x) throws MyException1, MyException2, MyException3 {
        System.out.println("Ex09#exception()");
        if (x == 1)
            throw new MyException1("MyException1,x = " + x);
        if (x == 2)
            throw new MyException2("MyException2,x = " + x);
        if (x == 3)
            throw new MyException3("MyException3,x = " + x);
    }

    public static void main(String[] args) {
        try {
            exception(1);
            exception(2);
            exception(3);
        } catch (Exception e) {
            System.out.println("Caught Exception:");
            e.printStackTrace(System.out);
        }
    }
}
/**output:
 * Ex09#exception()
 * Caught Exception:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException1: MyException1,x = 1
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex09.exception(Ex09.java:27)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex09.main(Ex09.java:36)
 */