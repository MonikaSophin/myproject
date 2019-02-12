package com.thinkinginjava.generics.example.chapter15_7.ex15_7_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
class GenericBase<T> {
    private T element;
    public T getElement() { return element; }
    public void setElement(T element) { this.element = element; }
}

class Derived1<T> extends GenericBase<T> {}
class Derived2 extends GenericBase {} // 没有警告 在setElement()方法调用时会警告

 //!! class Derived3 extends GenericBase<?> {}
  // 意外的类型
  //   需要: 不带限制范围的类或接口
  //   找到:    ?

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object element = d2.getElement();
        d2.setElement(element); // warning
    }
}
