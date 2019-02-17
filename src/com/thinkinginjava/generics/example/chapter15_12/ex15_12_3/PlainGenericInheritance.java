package com.thinkinginjava.generics.example.chapter15_12.ex15_12_3;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:09
 * @Version: 1.0
 * @Description:
 */
class GenericSetter<T> {
    void set(T arg) { //不是自限定泛型
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base> {
    /**
     * 该方法是被重载了，而不是被重写了。
     * 所以基类中仍然有set(Base base)方法。
     */
    //@Override
    void set(Derived arg) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base);
    }
}
/**output:
 * DerivedGS.set(Derived)
 * GenericSetter.set(Base)
 */