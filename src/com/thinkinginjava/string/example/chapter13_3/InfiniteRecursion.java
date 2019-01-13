package com.thinkinginjava.string.example.chapter13_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/31 15:12
 * @Version: 1.0
 * @Description:
 */
public class InfiniteRecursion {
    public String toString() {//这里存在着递归。this会调用toString(), toString()会使用this。
        return "InfiniteRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 1; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }
}
/**output:
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:125)
 * 	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
 * 	at java.lang.StringBuilder.append(StringBuilder.java:136)
 * 	at com.thinkinginjava.string.example.chapter13_3.InfiniteRecursion.toString(InfiniteRecursion.java:14)
 * 	at java.lang.String.valueOf(String.java:2994)
 * 	at java.lang.StringBuilder.append(StringBuilder.java:131)
 * 	at com.thinkinginjava.string.example.chapter13_3.InfiniteRecursion.toString(InfiniteRecursion.java:14)
 * 	....
 */