package com.thinkinginjava.type_information.example.chapter14_9;

import com.thinkinginjava.type_information.example.chapter14_9.pageaccess.HiddenC;
import java.lang.reflect.Method;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 *  Method #setAccessible(true);使用反射可以到达并调用所有方法。（包括private修饰的方法）
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 编译错误:不能找到符号'C'
        /*if(a instanceof C) {
            C c = (C)a;
            c.g();
        }*/
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
/**output:
 * public C.f()
 * com.thinkinginjava.type_information.example.chapter14_9.pageaccess.C
 * public C.g()
 * package C.u()
 * protected C.v()
 * private C.w()
 */