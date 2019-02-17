package com.thinkinginjava.generics.example.chapter15_12.ex15_12_3;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:57
 * @Version: 1.0
 * @Description:
 */
class OrdinarySetter {
    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {
    /**
     * 该方法是被重载了，而不是被重写了。
     * 所以基类中仍然有set(Base base)方法。
     */
    //@Override
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        ds.set(base);
    }
}
/**output:
 * DerivedSetter.set(Derived)
 * OrdinarySetter.set(Base)
 */