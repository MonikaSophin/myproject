package com.thinkinginjava.inner_classes.example.chapter10_9;

/**
 * @Author: monika
 * @Date: 2018/12/9 20:05
 * @Version: 1.0
 * @Description:
 * 1.因为内部类的构造器必须连接到指向其外围类对象的引用，所以在继承内部类的时候，
 * 事情会变得有点复杂。问题在于，那个指向外围类对象的“秘密的”引用必须被初始化。
 * 而在导出类中不再存在可连接的默认对象。要解决这个问题，必须使用特殊的语法来明
 * 确说清它们之间的关联。
 */
class WithInner {
    class Inner {}
}

/**
 * 2.可以看到，InheritInner只能继承自内部类，而不是外部类。但是当要生成一个构造器时，
 * 默认的构造器不能编译，必须在内部类的导出类构造器中使用如下语法：
 * enclosingClassReference.super();
 * 这样才提供了必要的引用，然后程序才能编译通过。
 */
public class InheritInner extends WithInner.Inner {
    //! InheritInner(){} //不能编译通过
    InheritInner(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner inheritInner = new InheritInner(wi);
    }
}
