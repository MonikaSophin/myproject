package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12;

/**
 * @Author: monika
 * @Date: 2018/12/30 17:35
 * @Version: 1.0
 * @Description: page 281
 * 练习28：修改练习04，使客户的异常类继承自RuntimeException,并展示编译器允许你
 * 省略try语句块。
 */
class MyException extends RuntimeException {
    private String message;
    public MyException(String message) {
        super(message);
        this.message = message;
    }
    public void showMessage() { System.out.println(message); }
}

public class Ex28 {
    public static void main(String[] args) {
        throw new MyException("Throwing MyException from Ex28#main()");
    }
}
/**output:
 * Exception in thread "main" com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.MyException: Throwing MyException from Ex28#main()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Ex28.main(Ex28.java:22)
 */