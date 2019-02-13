package com.thinkinginjava.generics.exercise.chapter15_8;

/**
 * @Author: monika
 * @Date: 2019/2/13 20:42
 * @Version: 1.0
 * @Description: page 383
 * 练习23：修改FactoryConstraint.java,使得create()可以接受一个参数。
 */
interface FactoryI<T> {
    T create();
    T create(Integer args);
}

class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory, Integer args) {
        x = factory.create(args);
    }
    public void get() { System.out.println(x); }
}

class IntegerFactory implements FactoryI<Integer> {
    public Integer create() {
        return new Integer(0);
    }
    public Integer create(Integer args) { return new Integer(args); }
}

class Widget {
    int i;
    public static class Factory implements FactoryI<Widget> {
        public Widget create() {
            return new Widget();
        }
        public Widget create(Integer args) {
            Widget widget = new Widget();
            widget.i = args;
            return widget;
        }
    }

    @Override
    public String toString() { return "Widget{" + "i=" + i + '}'; }
}

class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory(), 22).get();
        new Foo2<>(new Widget.Factory(), 22).get();
    }
}

public class Ex23 {
    public static void main(String[] args) {
        FactoryConstraint.main(args);
    }
}
/**output:
 * 22
 * Widget{i=22}
 */