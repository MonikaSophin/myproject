package com.thinkinginjava.string.exercise.chapter13_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/31 15:19
 * @Version: 1.0
 * @Description: page 288
 * 练习02：修复InfiniteRecursion.java。
 */
class InfiniteRecursion {
    public String toString() {
        //这里存在着递归。this会调用toString(), toString()会使用this。
        //此时，若想打印出对象的内存地址，应该是使用Object.toString,也就是super.toString()
        return "InfiniteRecursion address: " + super.toString() + "\n";
    }
}

public class Ex02 {
    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 1; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }
}
/**output:
 * [InfiniteRecursion address: com.thinkinginjava.string.exercise.chapter13_3.InfiniteRecursion@4554617c
 * ]
 */