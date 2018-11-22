package com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_5;

/**
 * @Author: monika
 * @Date: 2018/11/20 22:35
 * @Version: 1.0
 * @Description:  如果某个方法是静态的，它的行为就不具有多态性。
 *                静态方法是与类，而并非与单个的对象相关联的。
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }
    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
/**Output:
Base staticGet()
Derived dynamicGet()
*/
