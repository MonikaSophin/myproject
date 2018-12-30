package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:49
 * @Version: 1.0
 * @Description: page 255
 * 练习06：创建两个异常类，每一个都自动记录它们的自己的日志，演示它们都可以正常运行。
 */
class MyException1 extends Exception{
    private static Logger logger = Logger.getLogger("MyException1");
    public MyException1() {
        StringWriter cause = new StringWriter();
        PrintWriter printWriter = new PrintWriter(cause);
        printStackTrace(printWriter);
        logger.severe(cause.toString());
    }
}

class MyException2 extends Exception{
    private static Logger logger = Logger.getLogger("MyException2");
    public MyException2() {
        StringWriter cause = new StringWriter();
        PrintWriter printWriter = new PrintWriter(cause);
        printStackTrace(printWriter);
        logger.warning(cause.toString());
    }
}

public class Ex06 {
    public static void main(String[] args) {
        try {
            throw new MyException1();
        } catch (MyException1 e) {
//            System.err.println("Caught :" + e);
        }
        try {
            throw new MyException2();
        } catch (MyException2 e) {
//            System.err.println("Caught :" + e);
        }
    }
}
/**output:
 * 十二月 26, 2018 11:14:08 下午 com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.MyException1 <init>
 * 严重: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.MyException1
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.Ex06.main(Ex06.java:37)
 *
 * 十二月 26, 2018 11:14:08 下午 com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.MyException2 <init>
 * 警告: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.MyException2
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.Ex06.main(Ex06.java:42)
 */