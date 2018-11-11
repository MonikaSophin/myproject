package com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:31
 * @Version: 1.0
 * @Description:
 */
public class VarargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }
    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }
    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]: " + new int[0].getClass());
    }
}
/**输出：
 * class [Ljava.lang.Character; length 1
 * class [Ljava.lang.Character; length 0
 * class [I length 1
 * class [I length 0
 * int[]: class [I
 *
 * 结论：前导的“["表示这是一个后面紧随的类型的数组，紧随的“I”表示基本类型int。
 * 使用可变参数类表可以不依赖自动包装机制，而实际上使用的是基本类型。
 * 然而，可变参数列表与自动包装机制可以和谐共处。
 */