package com.thinkinginjava.Initialize_clean.example.chapter5_7.ex5_7_1;

import com.thinkinginjava.Initialize_clean.example.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 15:34
 * @Version: 1.0
 * @Description:  无法阻止自动初始化成员变量的进行，它将在构造器被调用之前发生。
 */
class Window {
    Window(int marker) { Print.print("Window(" + marker + ")"); }
}

class House {
    Window w1 = new Window(1); // Before constructor
    House() {
        // Show that we're in the constructor:
        Print.print("House()");
        w3 = new Window(33); // Reinitialize w3
    }
    Window w2 = new Window(2); // After constructor
    void f() { Print.print("f()"); }
    Window w3 = new Window(3); // At end
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
}
/**输出：
 * Window(1)
 * Window(2)
 * Window(3)
 * House()
 * Window(33)
 * f()
 */
