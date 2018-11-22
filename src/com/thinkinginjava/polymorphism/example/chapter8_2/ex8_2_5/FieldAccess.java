package com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_5;

/**
 * @Author: monika
 * @Date: 2018/11/20 22:26
 * @Version: 1.0
 * @Description: 如果你直接访问某个域，这个访问就将在编译期进行编译。
 *              当Sub对象向上转型为Super引用时，任何域访问操作都将由
 *              编译器解析，因此不是多态的。在本例中，为Super.field和
 *              Sub.field分配了不同的存储空间。这样，Sub实际上包含了
 *              两个称为field的域，它自己的和它从Super处得到的。
 */
class Super {
    public int field;
    public int getField() { return field; }
}

class Sub extends Super {
    public int field = 1;
    public int getField() { return field; }
    public int getSuperField() { return super.field; }
}

public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // Upcast
        System.out.println("sup.field = " + sup.field +
                ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " +
                sub.field + ", sub.getField() = " +
                sub.getField() +
                ", sub.getSuperField() = " +
                sub.getSuperField());
    }
}
/** Output:
sup.field = 0, sup.getField() = 1
sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
*/