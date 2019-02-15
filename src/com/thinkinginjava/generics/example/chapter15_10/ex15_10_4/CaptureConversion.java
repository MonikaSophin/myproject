package com.thinkinginjava.generics.example.chapter15_10.ex15_10_4;

import com.thinkinginjava.generics.example.chapter15_10.ex15_10_1.Holder;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/15
 * @description:
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.getValue();
        System.out.println(t.getClass().getSimpleName());
    }

    /**
     *  在f2()中，f1()被调用，而f1(）需要一个已知参数。这里发生的是，
     *  参数类型在调用f2()的过程中被捕获，因此它可以在对f1(）的调用中被使用。
     *
     *  捕获转换只有在这样的情况下可以工作：即在方法内部，你需要使用确切的类型。 捕获转换使用非常受限。
     *  注意：不能从f2()中返回T，因为T对f2(）来说是未知的。
     */
    static void f2(Holder<?> holder) {
        f1(holder); // 带有捕获类型的调用
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);// 警告
        f2(raw);// 无警告

        Holder rawBasic = new Holder();
        rawBasic.setValue(new Object()); //警告
        f2(rawBasic); //无警告

        //向上转型为Holder<?>，仍然能算出来
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded); //无警告
    }
}
/**output:
 * Integer
 * Integer
 * Object
 * Double
 */