package com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:26
 * @Version: 1.0
 * @Description:
 */
public class NewVarArgs {
    //可变参数列表，编译器实际上会为你去填充数组。你获取的仍旧是一个数组。传入空列表也可以。
    static void printArray(Object... args) {
        for (Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Can take individual elements:
        printArray(new Integer(47), new Float(3.14),
                new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        // Or an array:
        printArray((Object[]) new Integer[]{1, 2, 3, 4});
        printArray(); // Empty list is OK
    }
}
/**输出：
 * 47 3.14 11.11
 * 47 3.14 11.11
 * one two three
 * com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@4554617c com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@74a14482 com.thinkinginjava.Initialize_clean.example.chapter5_8.ex5_8_1.A@1540e19d
 * 1 2 3 4
 */