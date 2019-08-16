package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/16
 * 创建Stream的几种方式
 */
public class CreateStream {
    public static void main(String[] args) {

        String[] strs = { "a", "b", "c", "d", "e"};

        //1 Stream.of(T... values): 接受可变参数的元素
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //这样一直创建无限个对象的流，也成为无限流；
        //2 Stream.iterate(final T seed, final UnaryOperator<T> f): 接受一个起始值，与'一元操作符'函数。可以无限生成对象的流。
        Stream<String> strs2 = Stream.iterate("a", x -> x + "a").limit(5);
        strs2.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //3 Stream.generate(Supplier<T> s): 接受一个供给型函数。可以无限生成对象的流。
        Stream<String> str3 = Stream.generate(() -> "A").limit(5);
        str3.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //4 Arrays.stream(T[] array) : 接受一个泛型数组
        Stream<String> str4 = Arrays.stream(strs);
        str4.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //5 Collection#stream()：集合类(继承自Collection接口)可以生成stream
        Stream<String> str5 = Arrays.asList(strs).stream();
        str5.forEach(s -> System.out.print(s + " "));
    }
}
/**output:
 * a b c d e
 * a aa aaa aaaa aaaaa
 * A A A A A
 * a b c d e
 * a b c d e
 */