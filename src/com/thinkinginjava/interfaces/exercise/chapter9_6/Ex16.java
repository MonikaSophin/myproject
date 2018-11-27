package com.thinkinginjava.interfaces.exercise.chapter9_6;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: monika
 * @Date: 2018/11/26 21:45
 * @Version: 1.0
 * @Description: page 183
 * 练习16：创建一个类，它将生成一个char序列，适配这个类，使其可以成为Scanner对象的一种输入。
 */
class CharAdapt implements Readable{
    private int count;
    public CharAdapt(int count) { this.count = count; }
    private static final char[] CHARS = "monika".toCharArray();

    @Override
    public int read(CharBuffer cb){
       if(count-- == 0)
            return -1; // 表示输入结束
        for(int i = 0; i < CHARS.length; i++) {
            cb.append(CHARS[i]);
        }
        cb.append(" ");
        return CHARS.length;
    }
}

public class Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new CharAdapt(3));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
/**输出：
 * monika
 * monika
 * monika
 */