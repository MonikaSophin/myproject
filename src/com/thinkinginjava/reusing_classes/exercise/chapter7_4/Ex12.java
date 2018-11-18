package com.thinkinginjava.reusing_classes.exercise.chapter7_4;

/**
 * @Author: monika
 * @Date: 2018/11/16 22:49
 * @Version: 1.0
 * @Description: page 135
 * 练习12：将一个适当的dispose()方法的层次结构添加到练习9的所有类中。
 */
class Component1 {
    Component1() { System.out.println("Component1()"); }
    void dispose(){ System.out.println("Component1#dispose()"); }
}

class Component2 {
    Component2() { System.out.println("Component2()"); }
    void dispose(){ System.out.println("Component2#dispose()"); }
}

class Component3 {
    Component3() { System.out.println("Component3()"); }
    void dispose(){ System.out.println("Component3#dispose()"); }
}

class Root {
    Component1 c1root ;
    Component2 c2root ;
    Component3 c3root ;
    Root() {
        System.out.println("Root()");
        c1root = new Component1();
        c2root = new Component2();
        c3root = new Component3();
    }
    void dispose(){
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        System.out.println("Root#dispose()");
    }
}

class Stem extends Root {
    Component1 c1stem ;
    Component2 c2stem ;
    Component3 c3stem ;
    Stem() {
        System.out.println("Stem()");
        c1stem = new Component1();
        c2stem = new Component2();
        c3stem = new Component3();
    }
    void dispose(){
        c3stem.dispose();
        c2stem.dispose();
        c1stem.dispose();
        super.dispose();
        System.out.println("Stem#dispose()");
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Stem stem = new Stem();
        try {
        // ...
        }finally {
            stem.dispose();
        }
    }
}
/**输出：
 * Root()
 * Component1()
 * Component2()
 * Component3()
 * Stem()
 * Component1()
 * Component2()
 * Component3()
 * Component3#dispose()
 * Component2#dispose()
 * Component1#dispose()
 * Component3#dispose()
 * Component2#dispose()
 * Component1#dispose()
 * Root#dispose()
 * Stem#dispose()
 */