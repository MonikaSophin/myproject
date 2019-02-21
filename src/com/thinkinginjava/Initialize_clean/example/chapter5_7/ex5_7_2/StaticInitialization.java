package com.thinkinginjava.Initialize_clean.example.chapter5_7.ex5_7_2;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 16:05
 * @Version: 1.0
 * @Description:  无论创建多少个对象，静态数据都只占用一份存储区域。static关键字不能应用于局部变量，
 *               因此它只能作用于域。如果一个域时静态的基本类型域，且也没有对它进行初始化，那么它就
 *               会获得基本类型的标准初值；如果他是一个对象引用，那么它的默认初始化值就是null。
 *
 *                静态初始化只在Class对象首次加载的时候进行一次。
 *
 *                静态初始化只有在必要时刻才会进行。
 *
 *                初始化的顺序是先静态对象（如果它们尚未因前面的对象创建过程而被初始化），而后是
 *              “非静态”对象。
 */
class Bowl {
    Bowl(int marker) {
        Print.print("Bowl(" + marker + ")");
    }
    void f1(int marker) {
        Print.print("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table() {
        Print.print("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        Print.print("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        Print.print("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        Print.print("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        Print.print("Creating new Cupboard() in main");
        new Cupboard();
        Print.print("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
/**输出：
 * Bowl(1)
 * Bowl(2)
 * Table()
 * f1(1)
 * Bowl(4)
 * Bowl(5)
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * Creating new Cupboard() in main
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * Creating new Cupboard() in main
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * f2(1)
 * f3(1)
 */
