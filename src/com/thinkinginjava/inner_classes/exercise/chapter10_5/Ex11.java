package com.thinkinginjava.inner_classes.exercise.chapter10_5;

/**
 * @Author: monika
 * @Date: 2018/12/5 17:48
 * @Version: 1.0
 * @Description: page 196
 * 练习11：创建一个private内部类，让它实现一个public接口。写一个方法，它返回一个
 * 指向此private内部类的实例的引用，并将此引用向上转型为该接口类型。通过尝试向下转型，
 * 说明此内部类被完全隐藏了。
 */
class Clazz11{
    private class InnerClazz11 implements Interface11{
        @Override
        public void method11() {
            System.out.println("Clazz11.InnerClazz11#method11()");
        }
    }
    public Interface11 getInnerClazz11(){
        return new InnerClazz11();
    }
}

public class Ex11 {
    public static void main(String[] args) {
        Clazz11 clazz11 = new Clazz11();
        Interface11 interface11 = clazz11.getInnerClazz11();
        interface11.method11();
        //访问不到此内部类，此内部类被完全隐藏了（被private修饰）
        //! Clazz11 clazz11 = (Clazz11) interface11;
        //! clazz11.method11();
    }
}
/**输出：
 * Clazz11.InnerClazz11#method11()
 */