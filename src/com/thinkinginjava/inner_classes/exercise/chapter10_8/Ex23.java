package com.thinkinginjava.inner_classes.exercise.chapter10_8;

/**
 * @Author: monika
 * @Date: 2018/12/8 21:47
 * @Version: 1.0
 * @Description: page 205
 * 练习23：创建一个接口U，它包含三个方法。创建第一个类A，它包含一个方法，在此
 * 方法中通过创建一个匿名内部类，来生成指向U的引用。创建第二个类B，它包含一个
 * 由U构成的数组。B应该有几个方法，第一个方法可以接受对U的引用并存储到数组中：
 * 第二个方法将数组中的引用设为null；第三个方法遍历此数组，并在U中调用这些方
 * 法。在main()中，创建一组A的对象和一个B的对象。用那些A类对象所产生的U类型
 * 的引用填充B对象的数组。使用B回调所有A的对象。再从B中移除某些U的引用。
 */
interface U {
    void f1();
    void f2();
    String f3();
}

class A {
    U getU() {
        return new U() {
            @Override
            public void f1() { System.out.println("f1()"); }
            @Override
            public void f2() { System.out.println("f2()"); }
            @Override
            public String f3() { return "I'm a U"; }
        };
    }
}

class B{
    private U[] us;
    public U[] getUs() { return us; }

    public B(int i) { us = new U[i]; }

    void addUs(U u,int i){ us[i] = u; }
    void setNull(int i){ us[i] = null; }
    void traverseAll(){//遍历us所有元素。
        for (U u: us) {
            u.f1();
            u.f2();
            System.out.println(u.f3());
        }
    }

    void showUs(){
        for (U u: us) {
            if (u!=null) System.out.println(u.f3());
            else System.out.println("I'm a null");
        }
    }
}

public class Ex23 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        B b = new B(3);
        b.addUs(a1.getU(),0);
        b.addUs(a2.getU(),1);
        b.addUs(a3.getU(),2);

        b.showUs();
        System.out.println();

        b.traverseAll();
        b.setNull(0);
        b.setNull(1);
        //! b.traverseAll();
        System.out.println();

        b.showUs();
    }
}
/**输出：
 * I'm a U
 * I'm a U
 * I'm a U
 *
 * f1()
 * f2()
 * I'm a U
 * f1()
 * f2()
 * I'm a U
 * f1()
 * f2()
 * I'm a U
 *
 * I'm a null
 * I'm a null
 * I'm a U
 */