package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_3;

/**
 * @Author: monika
 * @Date: 2018/12/28 0:12
 * @Version: 1.0
 * @Description: 不是书上的示例。
 * 1.异常链：捕获一个异常后抛出另一个异常，并且希望吧原始异常的信息保存下来。
 * 2.现在所有Throwable的子类在构造器中都可以接受一个cause对象作为参数。这个cause对象就表示原始异常，
 * 这样通过构造器把原始异常传递给新的异常，使得在当前位置创建并抛出新的异常，也能通过这个异常链追踪到
 * 异常最初发生的位置（也就是标准错误输出流中的Cause by所表示的位置）。
 * 2.在Throwable的子类中，只有三种基本的异常类提供了带cause参数的构造器（Error、Exception、RuntimeException）。
 * 如果要把其他的异常链接起来，应该使用{@link Throwable#initCause(Throwable)}方法而不是构造器。
 */
public class ExceptionChain {
    static void f() {
        try {
            throw new NoSuchFieldException("throw NoSuchFieldException from f()");
        } catch (NoSuchFieldException e) {
           throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        f();
    }
}
/**output：
 * Exception in thread "main" java.lang.RuntimeException: java.lang.NoSuchFieldException: throw NoSuchFieldException from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_3.ExceptionChain.f(ExceptionChain.java:20)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_3.ExceptionChain.main(ExceptionChain.java:25)
 * Caused by: java.lang.NoSuchFieldException: throw NoSuchFieldException from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ex12_6_3.ExceptionChain.f(ExceptionChain.java:18)
 * 	... 1 more
 */