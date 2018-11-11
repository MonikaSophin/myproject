package com.thinkinginjava.Initialize_clean.example.chapter5_7.ex5_7_3;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:15
 * @Version: 1.0
 * @Description:  Java允许将多个静态初始化动作组织成一个特殊的“静态子句”（有时也叫做“静态块”）。
 */
public class Spoon {
    static int i;
    static {//静态块
        i = 47;
    }
}
