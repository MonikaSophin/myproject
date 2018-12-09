package com.thinkinginjava.inner_classes.example.chapter10_7.ex10_7_1;

/**
 * @Author: monika
 * @Date: 2018/12/8 20:24
 * @Version: 1.0
 * @Description:
 * 1.正常情况下，不能在接口内部放置任何代码，但嵌套类可以作为接口的一部分。
 *  你放到接口中的任何类都自动地式public和static的。因为类是static的，
 *  只是将嵌套类置于接口的命名空间内，这并不违反接口的规则。你甚至可以在
 *  内部类中实现其外围接口，就像下面这样：
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{
        @Override
        public void howdy() { System.out.println("Howdy"); }
    }

    public static void main(String[] args) {
        new Test().howdy();
    }
}
/**输出：
 * Howdy
 */