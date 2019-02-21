package com.thinkinginjava.Initialize_clean.exercise.chapter5_7;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:25
 * @Version: 1.0
 * @Description: page 97
 * 练习13：验证前面段落中的语句。
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

public class Ex13 {
    public static void main(String[] args) {
        Print.print("Inside main()");
        Cups.cup1.f(99); // (1)
    }
    static Cups cups1 = new Cups(); // (2)
    static Cups cups2 = new Cups(); // (2)
}
/**输出：
 * Cup(1)
 * Cup(2)
 * Cups()
 * Inside main()
 * f(99)
 */