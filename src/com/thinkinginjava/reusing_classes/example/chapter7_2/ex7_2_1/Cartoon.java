package com.thinkinginjava.reusing_classes.example.chapter7_2.ex7_2_1;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:36
 * @Version: 1.0
 * @Description:  基类在导出类构造器可以访问它之前，就已经完成了初始化。即使你不为Cartoon()创建
 *               构造器，编译器也会为你合成一个默认的构造器，该构造器将调用基类的构造器。
 */
class Art {
    Art() { System.out.println("Art constructor"); }
}

class Drawing extends Art {
    Drawing() { System.out.println("Drawing constructor"); }
}

public class Cartoon extends Drawing {
    public Cartoon() { System.out.println("Cartoon constructor"); }
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
/**输出：
 * Art constructor
 * Drawing constructor
 * Cartoon constructor
 */