package com.thinkinginjava.io.exercise.chapter18_10;

import java.nio.CharBuffer;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/14
 * @description: page 556
 * 练习23：创建并测试一个实用方法，使其可以打印出CharBuffer中的内容，直到字符不能
 * 再打印为止。
 */
public class Ex23 {
    public static boolean isPrintable(char c) {
        // 检查可打印范围内的字符:
        return (((c >= '!') && (c <= '~')) ? true : false);
    }
    public static void printCharBuffer(CharBuffer cb) {
        cb.clear(); // 将位置设置为零，限制容量
        while(cb.hasRemaining()) {
            char c = cb.get();
            if(isPrintable(c))
                System.out.print(c);
        }
    }

    public static void main(String[] args) throws Exception {
        char[] ca = {'w','x','y','z'};
        CharBuffer cb = CharBuffer.wrap(ca);
        print("CharBuffer by wrapping char[]: ");
        printCharBuffer(cb);
        print();

        CharBuffer cb2 = CharBuffer.allocate(6);
        char[] ca2 = {'s','t','u','v','w'};
        cb2.put(ca2);
        print("CharBuffer by allocation: ");
        printCharBuffer(cb2);
        print();

        // 尝试一些不可打印的字符:
        char[] ca3 = {(char)0x01, (char)0x07, (char)0x7F,'b','y','e'};
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        print("CharBuffer including some unprintables: ");
        printCharBuffer(cb3);
    }
}
/**output:
 * CharBuffer by wrapping char[]:
 * wxyz
 * CharBuffer by allocation:
 * stuvw
 * CharBuffer including some unprintables:
 * bye
 */