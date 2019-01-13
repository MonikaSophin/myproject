package com.thinkinginjava.string.example.chapter13_5.ex13_5_2;

/**
 * @Author: monika
 * @Date: 2019/1/1 12:02
 * @Version: 1.0
 * @Description:
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
/**output:
 * Row 1: [5 5.332542]
 * Row 1: [5 5.332542]
 * Row 1: [5 5.332542]
 */