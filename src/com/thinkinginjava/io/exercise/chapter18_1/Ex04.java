package com.thinkinginjava.io.exercise.chapter18_1;

import com.thinkinginjava.util.Directory;

import java.io.File;

/**
 * @Author: monika
 * @Date: 2019/3/10 22:10
 * @Version: 1.0
 * @Description: page 532
 * 练习04：使用Directory.walk()来计算在目录中所有名字与特定的正则表达式相匹配的文件
 * 的尺寸总和。
 */
public class Ex04 {
    public static void main(String[] args) {
        long sum = 0;
        if(args.length == 0) {
            for(File file : Directory.walk(".").files) {
                System.out.print(file + ": ");
                System.out.println(file.length());
                sum += file.length();
            }

        }
        else
            for(String arg : args) {
                {
                    for(File file : Directory.walk(".", arg).files) {
                        System.out.print(file + ": ");
                        System.out.println(file.length());
                        sum += file.length();
                    }
                    System.out.println();
                }
            }
        System.out.println("Total size: " + sum);
    }
}
/**output:
 * 略~
 */