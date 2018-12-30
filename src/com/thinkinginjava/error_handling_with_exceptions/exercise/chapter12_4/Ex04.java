package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:31
 * @Version: 1.0
 * @Description: page 253
 * 练习04：使用extends关键字建立一个自定义异常类。为这个类写一个接受字符串参数的
 * 构造器，把此参数保存在对象内部的字符串引用中。写一个方法显示此字符串。写一个try-
 * catch子句，对这个新异常进行测试。
 */
class MyException extends Exception{
    private String message;
    public MyException(String message) {
        super(message);
        this.message = message;
    }
    public void showMessage(){
        System.out.println(message);
    }
}

public class Ex04 {
    public static void main(String[] args) {
        try {
            throw new MyException("Throwing MyException from Ex04#main()");
        } catch (MyException e) {
            e.showMessage();
        }
    }
}
/**output:
 * Throwing MyException from Ex04#main()
 */