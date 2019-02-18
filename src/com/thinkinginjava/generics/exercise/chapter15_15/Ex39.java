package com.thinkinginjava.generics.exercise.chapter15_15;

import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.Basic;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.BasicImp;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.SerialNumbered;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.SerialNumberedImp;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.TimeStamped;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.TimeStampedImp;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_4.MixinProxy;
import com.thinkinginjava.generics.exercise.chapter15_15.color.Colored;
import com.thinkinginjava.generics.exercise.chapter15_15.color.ColoredImp;

import java.util.Random;

import static com.thinkinginjava.generics.example.chapter15_4.ex15_4_5.util.Tuple.tuple;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description: page 416
 * 练习39： 向DynamicProxyMixin.java中添加一个新的混型类Colored，将其混入
 * Mixin，并展示它可以工作。
 */
public class Ex39 {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class),
                tuple(new ColoredImp(), Colored.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        Colored c = (Colored) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerilaNumber());
        System.out.println(c.getColor());
    }
}
/**output(80% match):
 * Hello
 * 1550474660950
 * 1
 * black
 */