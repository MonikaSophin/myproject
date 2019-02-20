package com.thinkinginjava.arrays.example.chapter16_4;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description:
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 },
        };

        /**
         * {@link Arrays#deepToString(Object[])}
         *   返回指定数组的“深层内容”的字符串表示形式。
         * 如果数组包含其他数组作为元素，则字符串表示包含其内容，
         * 依此类推。此方法*用于将多维数组转换为字符串。
         */
        System.out.println(Arrays.deepToString(a));
    }
}
/**output:
 * [[1, 2, 3], [4, 5, 6]]
 */