package com.monika.jdk8.new_features_for_java.lambda_expressions_functional_interfaces;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        //在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。例如：
        Arrays.asList("a","b","c","d").forEach( e -> System.out.print(e) );
        System.out.println();

        //请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
        Arrays.asList("a","b","c","e").forEach((String s) -> System.out.print(s));
        System.out.println();

        //在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。例如：
        Arrays.asList("1","3","5","2").forEach( e -> {System.out.print(e);
                                                 System.out.print(e);
                                                 });
        System.out.println();

        //Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。
        // 例如，下面两个代码片段是等价的：
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach( (String e ) -> System.out.print( e + separator ) );
        System.out.println();
        final String separator1 = ",";
        Arrays.asList( "a", "b", "d" ).forEach(( String e ) -> System.out.print( e + separator1 ) );
        System.out.println();

        //Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，
        // 那么没有必要显式使用return语句。下面两个代码片段是等价的：
        Arrays.asList("a","d","b").sort((e1,e2) -> e1.compareTo(e2));
        Arrays.asList("a","d","b").sort((e1,e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        System.out.println();
    }
}
