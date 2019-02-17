package com.thinkinginjava.generics.example.chapter15_12.ex15_12_2;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:41
 * @Version: 1.0
 * @Description:
 */
public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }
}

class A2 extends NotSelfBounded<A2> {}
class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 c2) {
        set(c2);
        return get();
    }
}

class D2 {}

//没有自限定限制，这个是可以编译运行的。
class E2 extends NotSelfBounded<D2> {}