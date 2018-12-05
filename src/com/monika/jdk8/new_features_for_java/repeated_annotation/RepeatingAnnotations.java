package com.monika.jdk8.new_features_for_java.repeated_annotation;

import java.lang.annotation.*;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *   自从Java 5引入了注解机制，这一特性就变得非常流行并且广为使用。然而，使用注解的一个限制是
 * 相同的注解在同一位置只能声明一次，不能声明多次。Java 8打破了这条规则，引入了重复注解机制，
 * 这样相同的注解可以在同一地方声明多次。
 *   重复注解机制本身必须用@Repeatable注解。事实上，这并不是语言层面上的改变，更多的是编译器的
 * 技巧，底层的原理保持不变。让我们看一个快速入门的例子：
 */
public class RepeatingAnnotations {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable{
    }

    public static void main(String[] args) {
        for (Annotation annotation : Filterable.class.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("---------");

        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
        System.out.println("---------");

        Filters filters = Filterable.class.getAnnotation(Filters.class);
        for (Filter filter: filters.value()) {
            System.out.println(filter.value());
        }
    }
}
/**
 *   正如我们看到的，这里有个使用@Repeatable( Filters.class )注解的注解类Filter，
 * Filters仅仅是Filter注解的数组，但Java编译器并不想让程序员意识到Filters的存在。
 * 这样，接口Filterable就拥有了两次Filter（并没有提到Filter）注解。
 *   同时，反射相关的API提供了新的函数getAnnotationsByType()来返回重复注解的类型
 *（请注意Filterable.class.getAnnotation( Filters.class)经编译器处理后将会返回
 * Filters的实例）。
 *   程序输出结果如下：
 */
/**输出：
 * @com.monika.jdk8.new_features_for_java.repeated_annotation.RepeatingAnnotations$Filters
 * (value=[@com.monika.jdk8.new_features_for_java.repeated_annotation.RepeatingAnnotations$Filter(value=filter1),
 * @com.monika.jdk8.new_features_for_java.repeated_annotation.RepeatingAnnotations$Filter(value=filter2)])
 * ---------
 * filter1
 * filter2
 * ---------
 * filter1
 * filter2
 */