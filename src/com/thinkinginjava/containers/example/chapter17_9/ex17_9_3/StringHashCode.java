package com.thinkinginjava.containers.example.chapter17_9.ex17_9_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description:
 * String有个特点：如果程序中有多个String对象，都包含相同的字符串序列，
 * 那么这些String对象都映射到同一块内存区域。所以new String("hello")
 * 生成的两个实例，虽然是相互独立的，但是对它们使用hashCode()应该生成
 * 同样的结果。
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        /**
         * {@link String#hashCode()} 是基于String的内容的。
         */
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
/**output:
 * 69609650
 * 69609650
 */