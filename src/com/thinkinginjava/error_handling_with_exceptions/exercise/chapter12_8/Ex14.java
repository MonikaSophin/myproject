package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.OnOffException1;
import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.OnOffException2;
import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1.Switch;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:58
 * @Version: 1.0
 * @Description: page 267
 * 练习14：试说明，在OnOffSwitch.java的try块内部抛出RuntimeException,程序可能会
 * 出现错误。
 */
public class Ex14 {
    public static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {
        throw new RuntimeException("from f()");
    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
            sw.off();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
            sw.off();
        }
    }
}
/**output (30% match):
 * on
 * Exception in thread "main" java.lang.RuntimeException: from f()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex14.f(Ex14.java:18)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8.Ex14.main(Ex14.java:24)
 *  注意：程序被异常终止了。并没有输出到off。
 */