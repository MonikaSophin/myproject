package com.thinkinginjava.string.exercise.chapter13_7;

import java.util.Scanner;

/**
 * @Author: monika
 * @Date: 2019/1/13 19:23
 * @Version: 1.0
 * @Description: page 310
 * 练习20：编写一个包含int、long、float、double和String属性的类。为它编写一个构造器，
 * 接收一个String参数。然后扫描该字符串，为各个属性赋值。再添加一个toString()方法，用来
 * 演示你的类是否工作正确。
 */
class Clazz20 {
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;

    public Clazz20(String input) {
        Scanner scanner = new Scanner(input);
        i = scanner.nextInt();
        l = scanner.nextLong();
        f = scanner.nextFloat();
        d = scanner.nextDouble();
        s = scanner.next();
    }

    @Override
    public String toString() {
        return "Clazz20{" +
                "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}

public class Ex20 {
    public static void main(String[] args) {
        int i = 2;
        long l = 2L;
        float f = 2.0F;
        double d = 2.0D;
        String s = "String字符串";
        String input = i + " " + l + " " + f + " " + d + " "  + s;
        System.out.println(input);
        Clazz20 clazz20 = new Clazz20(input);
        System.out.println(clazz20);
    }
}
/**output:
 * 2 2 2.0 2.0 String字符串
 * Clazz20{i=2, l=2, f=2.0, d=2.0, s='String字符串'}
 */