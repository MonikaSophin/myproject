package com.thinkinginjava.reusing_classes.exercise.chapter7_8;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:41
 * @Version: 1.0
 * @Description: page 142
 * 练习19：创建一个含有指向某对象的空白final引用的类。在所有构造器内部都指向空白
 * final的初始化动作。说明java确保final在使用前必须被初始化，且一旦被初始化即无法改变。
 */
class Poppet {
    private int i;
    Poppet(int k) { i = k; }
    public String toString() { return ("Poppet " + i); }
}

public class Ex19 {
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:
    public Ex19() {
        p = new Poppet(1); // Initialize blank final reference
    }
    public Ex19(int x) {
        p = new Poppet(x); // Initialize blank final reference
    }
    public static void main(String[] args) {
        Ex19 b1 = new Ex19();
        Ex19 b2 = new Ex19(47);
        // b1.p = new Poppet(2); // Errors: cannot assign values
        // b2.p = new Poppet(3); // to final variables p
        System.out.println("b1.p: " + b1.p);
        System.out.println("b2.p: " + b2.p);
    }
}
/**输出：
 * b1.p: Poppet 1
 * b2.p: Poppet 47
 */