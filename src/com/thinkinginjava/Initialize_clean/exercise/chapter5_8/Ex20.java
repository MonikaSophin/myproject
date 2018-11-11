package com.thinkinginjava.Initialize_clean.exercise.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:58
 * @Version: 1.0
 * @Description: page 105
 * 练习20：创建一个实验可变参数列表而不是普通的main()语法的main()。打印所产生的
 * args数组的所有元素，并用各种不同数量的命令行参数来测试它。
 */
public class Ex20 {
    public static void main(String... args) {
        for(String s : args)
            System.out.print(s + " ");
        System.out.println();
    }
}
