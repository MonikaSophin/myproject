package com.monika.jdk8.new_features_for_java.extend_annotation_support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *    Java 8扩展了注解的上下文。现在几乎可以为任何东西添加注解：
 * 局部变量、泛型类、父类与接口的实现，就连方法的异常也能添加注解。
 *   下面演示几个例子：
 */
public class Annotations {
    /**
     *     ElementType.TYPE_USE和ElementType.TYPE_PARAMETER
     * 是两个新添加的用于描述适当的注解上下文的元素类型。在Java语
     * 言中，注解处理API也有小的改动来识别新增的类型注解。
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
    public @interface NonEmpty{
    }

    public static class Holder<@NonEmpty T> extends @NonEmpty Object{
        public void method() throws @NonEmpty Exception{
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        final @NonEmpty Holder<String> holder = new @NonEmpty Holder<>();
        @NonEmpty Collection<@NonEmpty String> strings = new ArrayList<>();
    }
}
