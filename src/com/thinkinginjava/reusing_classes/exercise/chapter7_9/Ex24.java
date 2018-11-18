package com.thinkinginjava.reusing_classes.exercise.chapter7_9;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:48
 * @Version: 1.0
 * @Description: page 147
 * 练习24：在Beetle.java中，从Beetle类继承产生一个具体类型的“甲壳虫”。其形式与现
 * 有类相同，跟踪并解释其输出结果。
 */
class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized");
}

public class Ex24 extends Beetle {
    private int n = printInit("Ex24.n initialized");
    public Ex24() {
        System.out.println("n = " + n);
        System.out.println("j = " + j);
    }
    private static int x3 = printInit("static Ex24.x3 initialized");
    public static void main(String[] args) {
        System.out.println("Ex24 constructor");
        new Ex24();
    }
}
/**输出：
 * static Insect.x1 initialized
 * static Beetle.x2 initialized
 * static Ex24.x3 initialized
 * Ex24 constructor
 * i = 9, j = 0
 * Beetle.k initialized
 * k = 47
 * j = 39
 * Ex24.n initialized
 * n = 47
 * j = 39
 */
