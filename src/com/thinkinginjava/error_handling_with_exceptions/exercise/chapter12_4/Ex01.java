package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:21
 * @Version: 1.0
 * @Description: page 253
 * 练习01：编写一个类，在其main()方法的try块里抛出一个Exception类的对象。传递一个
 * 字符串参数给Exception的构造器。在catch子句里捕获此异常对象，并且打印字符串参数。
 * 添加一个finally子句，打印一条信息以证明这里确实得到了执行。
 */
public class Ex01 {
    public static void main(String[] args) {
        try {
            throw new Exception("Ex01#main() throw Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }
}
/**output:
 * Ex01#main() throw Exception
 * finally
 */