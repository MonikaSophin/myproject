package com.thinkinginjava.reusing_classes.example.chapter7_9.ex7_9_1;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:54
 * @Version: 1.0
 * @Description:    类加载顺序：
 *                1.一般来说，可以说：“类的代码在初次使用时才加载。”这通常是指加载
 *                发生于创建类的第一对象之时，但是当访问static域或static方法时，
 *                也会发生加载。
 *                2.初次使用之处也是static初始化发生之处。所有的static对象和static
 *                代码段都会在加载时依程序中的顺序（即：定义类时的书写顺序）而依次初始
 *                化。当然，定义static的东西只会被初始化一次。
 */
class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 =
            printInit("static Insect.x1 initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");
    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
/** 输出:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*/
