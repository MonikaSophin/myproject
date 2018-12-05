package com.monika.jdk8.new_features_for_java_classlibs.parallel_array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 */
public class ParallelArrays {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.println(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.println(i + " "));
        System.out.println();
    }
}
/**输出（随机数据）：
 * 959044
 * 217140
 * 236156
 * 480078
 * 155110
 * 718278
 * 551846
 * 898172
 * 978419
 * 417080
 *
 * 6
 * 24
 * 113
 * 161
 * 183
 * 231
 * 266
 * 337
 */