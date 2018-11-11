package com.thinkinginjava.Initialize_clean.example.chapter5_7.ex5_7_3;

import com.thinkinginjava.Initialize_clean.example.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:19
 * @Version: 1.0
 * @Description:  静态块与其他静态初始化动作一样，这段代码仅执行一次：当首次生成这个类的一个对象时，
 *               或者首次访问属于那个类的静态数据成员时（即使从未生成过那个类的对象）。
 */
class Cup {
    Cup(int marker) {
        Print.print("Cup(" + marker + ")");
    }
    void f(int marker) {
        Print.print("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups() {
        Print.print("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        Print.print("Inside main()");
        Cups.cup1.f(99);  // (1)
    }
    // static Cups cups1 = new Cups();  // (2)
    // static Cups cups2 = new Cups();  // (2)
}
/**输出：
 * Inside main()
 * Cup(1)
 * Cup(2)
 * f(99)
 */