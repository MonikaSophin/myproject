package com.thinkinginjava.reusing_classes.example.chapter7_8.ex7_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:41
 * @Version: 1.0
 * @Description:  空白final
 *            1. java允许生成"空白final"，所谓空白final是指被声明为final但又未给定初始值的域。
 *            无论什么情况，编译器都确保空白final在使用前必须被初始化（在构造器中初始化）。
 *            但是，空白final在关键字final的使用上提供了更大的灵活性。
 *            为此，一个类中的final域就可以做到根据对象而有所不同，却又保持其恒定不变的特性。
 *
 *       下面就是一个例子：
 */
class Poppet {
    private int i;
    Poppet(int ii) { i = ii; }
}

public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }
    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }
    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}