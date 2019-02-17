package com.thinkinginjava.generics.example.chapter15_12.ex15_12_1;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:22
 * @Version: 1.0
 * @Description:
 */
class SubType extends BasicHolder<SubType> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        SubType st1 = new SubType();
        SubType st2 = new SubType();
        st1.set(st2);
        SubType st3 = st1.get();
        st1.f();
    }
}
/**output:
 * SubType
 */