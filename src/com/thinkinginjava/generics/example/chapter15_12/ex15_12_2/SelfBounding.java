package com.thinkinginjava.generics.example.chapter15_12.ex15_12_2;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:31
 * @Version: 1.0
 * @Description:
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }
}

class A extends SelfBounded<A> {}

//这样也可以。满足条件在SelfBounded<T extends SelfBounded<T>>的范围
class B extends SelfBounded<A> {}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}

// 编译错误：类型参数D不是这个SelfBounded<T extends SelfBounded<T>>的范围
//class E extends SelfBounded<D> {}

//可以这样做，不会有任何警告。因此自限定惯用法不是可强制执行的。
class F extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
