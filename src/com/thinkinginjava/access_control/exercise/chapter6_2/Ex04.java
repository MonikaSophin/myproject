package com.thinkinginjava.access_control.exercise.chapter6_2;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:49
 * @Version: 1.0
 * @Description: page 120
 * 练习04：展示protected方法具有包访问权限，但不是public
 */
public class Ex04 {
    protected void test(){
        System.out.println("继承访问权限:protected —— 本包下不是该类的子类也能访问该方法");
    }
}
