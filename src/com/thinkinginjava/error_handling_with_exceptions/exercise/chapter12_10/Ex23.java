package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10;

/**
 * @Author: monika
 * @Date: 2018/12/30 16:26
 * @Version: 1.0
 * @Description: page 275
 * 练习23：在前一个练习中添加一个dispose()方法。修改FailingConstructor,使其构造器
 * 可以将那些可去除对象之一当作一个成员对象创建，然后该构造器可能会抛出一个异常，之后它将
 * 创建第二个可去除成员对象。编写能够确保不出现故障的代码，并在main()中验证所有可能的故障
 * 情形都被覆盖了。
 */
class Disposable {
    private static int counter = 0;
    private int id = counter++;
    private boolean disposed;
    Disposable() {
        disposed = false;
    }
    void dispose() {
        disposed = true;
    }
    String checkStatus() {
        return (id + " " + (disposed ? "disposed" : "not disposed"));
    }
}

class FailingConstructor23 {
    private Integer[] ia = new Integer[2];
    private static Disposable d0;
    private static Disposable d1;
    FailingConstructor23() throws Exception {
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
        }
    }
}

public class Ex23 {
    public static void main(String[] args) {
        try {
            // the constructor catches its own exceptions:
            FailingConstructor23 fc = new FailingConstructor23();
        } catch(Exception e) {
            System.err.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        }
    }
}
/**output:
 * Caught e in middle try loop
 * Disposing d0
 * java.lang.ArrayIndexOutOfBoundsException: 2
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.FailingConstructor23.<init>(Ex23.java:36)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_10.Ex23.main(Ex23.java:63)
 */