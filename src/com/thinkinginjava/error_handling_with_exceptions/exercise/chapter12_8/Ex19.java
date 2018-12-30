package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

import com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_3.LostMessage;

/**
 * @Author: monika
 * @Date: 2018/12/28 23:42
 * @Version: 1.0
 * @Description: page 269
 * 练习19：通过确保finally子句中的调用，来修复LostMessage.java中的问题。
 */
public class Ex19 {
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } catch (Exception e) {
                System.out.println("inner try block: " + e);
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println("outer try block: " + e);
        }
    }
}
/**output:
 * inner try block: VeryImportantException!
 * outer try block: HoHumException！
 */