package com.thinkinginjava.inner_classes.example.chapter10_8.ex10_8_1;

/**
 * @Author: monika
 * @Date: 2018/12/9 12:40
 * @Version: 1.0
 * @Description:
 * 1.闭包（closure）是一个可调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。
 * 通过这个定义，可以看出内部类是面向对象的闭包，因为它不仅包含外围类对象（创建内部类的作
 * 用域）的信息，还自动拥有一个指向此外围类对象的引用，在此作用域内，内部类有权操作所有的
 * 成员，包括private成员。
 * 2.回调（callback）的价值在于它的灵活性——可以在运行时动态地决定需要调用什么方法。
 */
interface Incrementable{ void increment();}

class MyIncrement{
    public void increment(){ System.out.println("Other operation"); }
    static void f(MyIncrement mi){ mi.increment(); }
}

class Callee1 implements Incrementable{
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() { Callee2.this.increment(); }
    }

    Incrementable getCallbackReference(){ return new Closure(); }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh){ callbackReference = cbh; }
    void go(){ callbackReference.increment(); }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        System.out.println();

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        System.out.println();
        caller2.go();
        caller2.go();
    }
}
/**输出：
 * Other operation
 * 1
 *
 * 1
 * 2
 *
 * Other operation
 * 2
 * Other operation
 * 3
 */