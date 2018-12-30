package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2;

/**
 * @Author: monika
 * @Date: 2018/12/27 23:21
 * @Version: 1.0
 * @Description:
 */
class OneException extends Exception {
    public OneException(String message) { super(message); }
}

class TwoException extends Exception {
    public TwoException(String message) { super(message); }
}

public class RethrowNew {
    public static void f() throws OneException {
        System.out.println("Originating the Exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e1) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e1.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        } catch (TwoException e2) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e2.printStackTrace(System.out);
        }
    }
}
/**output:
 * Originating the Exception in f()
 * Caught in inner try, e.printStackTrace()
 * com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.OneException: thrown from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.RethrowNew.f(RethrowNew.java:20)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.RethrowNew.main(RethrowNew.java:26)
 * Caught in outer try, e.printStackTrace()
 * com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.TwoException: from inner try
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_2.RethrowNew.main(RethrowNew.java:30)
 */