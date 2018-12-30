package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:29
 * @Version: 1.0
 * @Description: page 275
 * 练习24：在FailingConstructor类中添加一个dispose()方法，并编写代码正确使用这个类。
 */
class FailingConstructor24 {
    private Integer[] ia = new Integer[2];
    private static Disposable d0;
    private static Disposable d1;
    FailingConstructor24() throws Exception {
        try {
            d0 = new Disposable();
            try {
                ia[2] = 2; 	// causes exception thrown and
                // caught in middle try loop
                try {
                    d1 = new Disposable();
                } catch(Exception e) {
                    System.out.println("Caught e in inner try loop");
                    e.printStackTrace(System.err);
                    System.out.println("Failed to create d1");
                }
            } catch(Exception e) {
                System.out.println("Caught e in middle try loop");
                e.printStackTrace(System.err);
                System.out.println("Disposing d0");
                d0.dispose(); // d0 would have been created
            }
        } catch(Exception e) {
            System.out.println("Caught e in outer try loop");
            e.printStackTrace(System.err);
            System.out.println("Failed to create d0");
        }finally {
            disponse();
        }
    }

    public void disponse(){
        try{
            d0.dispose();
            d1.dispose();
        }catch (NullPointerException e){
            System.out.println("disponse() failed.");
        }

    }
}

public class Ex24 {
    public static void main(String[] args) {
        try {
            // the constructor catches its own exceptions:
            FailingConstructor24 fc = new FailingConstructor24();
        } catch(Exception e) {
            System.err.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        }
    }
}
/**output:
 * Caught e in middle try loop
 * Disposing d0
 * disponse() failed.
 * java.lang.ArrayIndexOutOfBoundsException: 2
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.FailingConstructor24.<init>(Ex24.java:18)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.Ex24.main(Ex24.java:57)
 */