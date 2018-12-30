package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_5;

/**
 * @Author: monika
 * @Date: 2018/12/26 23:27
 * @Version: 1.0
 * @Description: page 256
 * 练习08：定义一个类，令其方法抛出在练习2里定义的异常。不用异常说明，看看是否通过
 * 编译。然后加上异常说明，用try-catch子句测试该类和异常。
 */
class Exception8 extends Exception {
    private String msg;
    Exception8(String msg) {
        super(msg);
        System.out.println("Exception8()");
        this.msg = msg;
    }
    protected void showS() {
        System.out.println("Message from Exception8: " + msg);
    }
}

class Test8 {
    public static void f() throws Exception8 {
        System.out.println("f()");
        throw new Exception8("Ouch from f()");
    }
}

public class Ex08 {
    public static void main(String[] args) {
        try {
            Test8 t = new Test8();
            t.f();
        } catch(Exception8 e) {
            System.err.println("Caught Exception8");
            e.printStackTrace();
            e.showS();
        }
    }
}
/**output (30% match):
 * f()
 * Exception8()
 * Message from Exception8: Ouch from f()
 * Caught Exception8
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_5.Exception8: Ouch from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_5.Test8.f(Ex08.java:26)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_5.Ex08.main(Ex08.java:34)
 */