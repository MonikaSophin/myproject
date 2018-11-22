package com.thinkinginjava.polymorphism.example.chapter8_3.ex8_3_1;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:06
 * @Version: 1.0
 * @Description: 构造器具有一项特殊任务：检查对象是否被正确地构造。
 *           导出类只能访问它自己的成员，不能访问基类中的成员（基类成员通常是private修饰的）。
 *           只有基类的构造器才具有恰当的知识和权限来对自己的元素进行初始化。因此，必须令所有的
 *           构造器都得到调用，否则就不能正确构造完整的对象。这正是编译器为什么要强制每个导出类
 *           都必须调用构造器的原因。
 *               构造动作一经发生，那么对象的全体成员都会得到构建。然而，在构造器内部，我们必须
 *            确保所要使用的成员都已经构建完毕。
 */
class Meal {
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    //private Lettuce lettuce = new Lettuce();
    PortableLunch() { System.out.println("PortableLunch()");}
}

public class Sandwich extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    public Sandwich() { System.out.println("Sandwich()"); }

    public static void main(String[] args) {
        new Sandwich();
    }
}
/**输出:
 * Meal()
 * Lunch()
 * PortableLunch()
 * Bread()
 * Cheese()
 * Lettuce()
 * Sandwich()
 */