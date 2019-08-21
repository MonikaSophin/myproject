package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/21
 * IntStream/LongStream/DoubleStream的操作，
 * 基本与Stream类似，但是有一些不同的方法
 * 创建操作请参考{@link CreateStream}
 * 中间操作请参考{@link IntermediateOperation}
 * 终端操作请参考{@link TerminalOperation}
 */
public class IntStreamTest {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};

        //1. asLongStream()、asDoubleStream
        DoubleStream longStream = IntStream.of(ints)
                .asDoubleStream();
        longStream.forEach(e -> System.out.print(e + " "));
        System.out.println();

        //2. 将Stream中所有元素进行装箱
        // boxed()
        Stream<Integer> boxed = IntStream.of(ints)
                .boxed();
        boxed.forEach(e -> System.out.print(e + " "));
        System.out.println();

        //3. 求IntStream中的所有元素的平均值
        // average()
        OptionalDouble average = IntStream.of(ints)
                .average();
        System.out.println("average: " + average);

        //4. 求IntStream中的所有元素的总和
        // sum()
        int sum = IntStream.of(ints)
                .sum();
        System.out.println("sum: " + sum);

        //5. 求IntStream中的所有元素的统计信息（元素个数，元素总和，元素最小值，元素平均值，元素最大值）
        // summaryStatistics()
        IntSummaryStatistics intSummaryStatistics = IntStream.of(ints)
                .summaryStatistics();
        System.out.println("intSummaryStatistics: " + intSummaryStatistics);

        //6. 形成一个左闭右开的区间[0, ints.length)，常用作带 数组(集合)下标的遍历。
        //range()
        IntStream.range(0, ints.length)
                .forEach(i -> {
                    ints[i] = ints[i] + 1;// 将元素自增
                    System.out.print(ints[i] + " ");
                });
        System.out.println();

        //7. 形成一个左闭右闭的区间[0, ints.length-1]，常用作带 数组(集合)下标的遍历。
        //rangeClosed()
        IntStream.rangeClosed(0, ints.length - 1)
                .forEach(i -> {
                    ints[i] = ints[i] + 1;// 将元素自增
                    System.out.print(ints[i] + " ");
                });
        System.out.println();
    }

}
/**output:
 * 1.0 2.0 3.0 4.0 5.0
 * 1 2 3 4 5
 * average: OptionalDouble[3.0]
 * sum: 15
 * intSummaryStatistics: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
 * 2 3 4 5 6
 * 3 4 5 6 7
 */