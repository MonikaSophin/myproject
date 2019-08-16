package com.monika.jdk8.new_features_for_java.lambda_expressions_functional_interfaces;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/15
 */
public class Lambda {
    public static void main(String[] args) {
        //1.没有参数
        Runnable noArguments = () -> System.out.println("Hello World");

        //2.仅有一个参数
        ActionListener oneArgument = event -> System.out.println("button clicked");

        //3.有多个方法块
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        //4.未指定参数类型
        BinaryOperator<Long> add = (x, y) -> x + y;

        //5.指定参数类型
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        //例如：
        Stream<String> a = Stream.iterate("a", new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s + "a";
            }
        }).limit(5);
        a.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //=====>等同于
        Stream<String> a1 = Stream.iterate("a", s -> s + "a").limit(5);
        a1.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
/**output:
 * a aa aaa aaaa aaaaa
 * a aa aaa aaaa aaaaa
 */