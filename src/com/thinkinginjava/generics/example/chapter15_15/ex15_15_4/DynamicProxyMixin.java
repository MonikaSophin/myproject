package com.thinkinginjava.generics.example.chapter15_15.ex15_15_4;

import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.Basic;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.BasicImp;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.SerialNumbered;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.SerialNumberedImp;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.TimeStamped;
import com.thinkinginjava.generics.example.chapter15_15.ex15_15_2.TimeStampedImp;
import static com.thinkinginjava.util.Tuple.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerilaNumber());
    }
}
/**output(66% match):
 * Hello
 * 1550473760055
 * 1
 */