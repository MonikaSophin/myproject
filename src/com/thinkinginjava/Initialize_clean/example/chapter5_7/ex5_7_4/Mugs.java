package com.thinkinginjava.Initialize_clean.example.chapter5_7.ex5_7_4;

import com.thinkinginjava.Initialize_clean.example.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:43
 * @Version: 1.0
 * @Description:  实例初始化看起来与静态代码块相似，只不过少了static关键字。这种语法对于支持“匿名
 *              内部类”（参见第10章）的初始化时必须的，但是它使得你可以保证无论调用了那个显式构造器，
 *              该实例初始化代码块的动作都会发生。  它会在构造器之前执行。
 */
class Mug {
    Mug(int marker) {
        Print.print("Mug(" + marker + ")");
    }
    void f(int marker) {
        Print.print("f(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        Print.print("mug1 & mug2 initialized");
    }
    Mugs() {
        Print.print("Mugs()");
    }
    Mugs(int i) {
        Print.print("Mugs(int)");
    }

    public static void main(String[] args) {
        Print.print("Inside main()");
        new Mugs();
        Print.print("new Mugs() completed");
        new Mugs(1);
        Print.print("new Mugs(1) completed");
    }
}
/**输出：
 * Inside main()
 * Mug(1)
 * Mug(2)
 * mug1 & mug2 initialized
 * Mugs()
 * new Mugs() completed
 * Mug(1)
 * Mug(2)
 * mug1 & mug2 initialized
 * Mugs(int)
 * new Mugs(1) completed
 */
