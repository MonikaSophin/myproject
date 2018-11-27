package com.thinkinginjava.interfaces.exercise.chapter9_1;

/**
 * @Author: monika
 * @Date: 2018/11/23 21:34
 * @Version: 1.0
 * @Description: page 172
 * 练习04：创建一个不包含任何方法的抽象类，从它那里导出一个类，并添加一个方法。
 * 创建一个静态方法，它可以接受指向基类的引用，将其向下转型到导出类，然后再调用
 * 该静态方法。在main()中，展现它的运行情况。然后，为基类中的方法加上abstract
 * 声明，这样就不再需要进行向下转型。
 */

abstract class Dad {
}

class Son extends Dad {
    protected void print() { System.out.println("Son"); }
}

abstract class SecondDad {
    abstract protected void print();
}

class SecondSon extends SecondDad {
    protected void print() { System.out.println("SecondSon"); }
}

public class Ex04 {
    public static void testPrint(Dad d) {
        ((Son)d).print();
    }
    public static void secondTestPrint(SecondDad sd) {
        sd.print();
    }
    public static void main(String[] args) {
        Son s = new Son();
        Ex04.testPrint(s);
        SecondSon ss = new SecondSon();
        Ex04.secondTestPrint(ss);
    }
}
/**输出：
 * Son
 * SecondSon
 */