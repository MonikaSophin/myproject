package com.thinkinginjava.access_control.exercise.chapter6_2.access;

import com.thinkinginjava.access_control.exercise.chapter6_2.Ex04;

/**
 * @Author: monika
 * @Date: 2018/11/13 21:51
 * @Version: 1.0
 * @Description:
 */
public class Ex04Test {
    public static void main(String[] args) {
        Ex04 ex04 =  new Ex04();
        //! ex04.test(); //不在同一个包下，不是子类，则不能访问protected方法
    }
}
