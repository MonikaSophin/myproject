package com.thinkinginjava.generics.exercise.chapter15_10;

import com.thinkinginjava.type_information.example.chapter14_3.pets.Cat;
import com.thinkinginjava.type_information.example.chapter14_3.pets.Pet;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description: page 395
 * 练习28：创建一个泛型列Generic1<T>,它只有一个方法，将接受一个T类型的参数。
 * 创建第二个泛型类Generic2<T>.它也只有一个方法，将返回类型T的参数。编写一个
 * 泛型方法，它具有一个调用第一个泛型类的方法的逆变参数。编写第二个泛型方法，它
 * 具有一个调用第二个泛型类的方法的协变参数。使用typeinfo.pets类库进行测试。
 */
class Generic1<T> {
    void f(T t) {
        System.out.println(String.format("Generic1<%s>.f();",
                t.getClass().getSimpleName()));
    }
}

class Generic2<T> {
    private T t;
    public Generic2(T t) { this.t = t; }
    T g() {
        System.out.println(String.format("Generic2<%s>.g();",
                t.getClass().getSimpleName()));
        return t;
    }
}

public class Ex28 {
    static <T> void f(Generic1<? super T> g, T t) {
        g.f(t);
    }
    static <T> T g(Generic2<? extends T> g) {
        return g.g();
    }

    public static void main(String[] args) {
        f(new Generic1<Pet>(), new Cat("kim"));
        g(new Generic2<>(new Pet()));
    }
}
/**output:
 * Generic1<Cat>.f();
 * Generic2<Pet>.g();
 */