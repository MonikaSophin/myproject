package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.OnOffException1;
import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.OnOffException2;
import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.Switch;

/**
 * @Author: monika
 * @Date: 2018/12/28 23:01
 * @Version: 1.0
 * @Description: page 267
 * 练习15：试说明，在WithFinally.java的try块内部抛出RuntimeException，程序不会
 * 出现错误。
 */
public class Ex15 {
    public static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {
        throw new RuntimeException("from f()");
    }
    public static void main(String[] args) {
        try {
            sw.on();
            f();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
        }finally {
            sw.off();
        }
    }
}
/**output(30% match):
 * on
 * off
 * Exception in thread "main" java.lang.RuntimeException: from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex15.f(Ex15.java:18)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex15.main(Ex15.java:23)
 * 请注意：这里虽然被抛出RuntimeException，但是执行到了off。
 */