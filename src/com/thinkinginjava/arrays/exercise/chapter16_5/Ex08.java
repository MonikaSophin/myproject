package com.thinkinginjava.arrays.exercise.chapter16_5;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
class A {}
public class Ex08 <T>{
    @SuppressWarnings("unchecked")
    T[] a = (T[])new Object[2]; // 编译警告：未经检查的强制转换
    public static void main(String[] args) {
        String[] sa = new String[2];
        // 编译错误：不兼容的类型
        //! sa[0] = new Integer(0);

        Object[] oa = new Object[3];
        oa[0] = new String("hi");
        oa[1] = new A(); // 任意对象
        int x = 2;
        oa[2] = x; // 自动装箱机制将int转换为Integer:
        System.out.println("oa[2]: " + oa[2].getClass());
        oa = sa;
        System.out.println("oa: " + oa.getClass());

        // 编译可以，但运行时ArrayStoreException：
        // oa[0] = 3;
    }
}
/**output:
 * oa[2]: class java.lang.Integer
 * oa: class [Ljava.lang.String;
 */