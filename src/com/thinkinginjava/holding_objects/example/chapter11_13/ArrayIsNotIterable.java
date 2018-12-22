package com.thinkinginjava.holding_objects.example.chapter11_13;

import java.util.Arrays;

/**
 * @Author: monika
 * @Date: 2018/12/22 14:55
 * @Version: 1.0
 * @Description:
 * 1.因为把数组当作成Iterable是错误的，不存在任何从数组到Iterable的自动转换。
 * 所以需要手工执行这种转换。
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib)
            System.out.print(t + " ");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        //! test(strings);
        test(Arrays.asList(strings));
    }
}
/**output:
 * 1 2 3 A B C
 */