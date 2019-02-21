package com.thinkinginjava.operators.example.chapter3_1;

import com.thinkinginjava.util.Print;
import java.util.Date;

/**
 * 书中用到了静态导入，需将该包路径设置到classpath路径下，这里为了方便故不使用静态导入。
 */
public class HelloDate {
    public static void main(String[] args) {
        Print.print("Hello it`s: ");
        Print.print(new Date());
    }
}
/**输出：
 * Hello it`s:
 * Tue Oct 30 21:20:24 CST 2018
 */