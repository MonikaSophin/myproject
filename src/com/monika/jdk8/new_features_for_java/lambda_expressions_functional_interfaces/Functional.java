package com.monika.jdk8.new_features_for_java.lambda_expressions_functional_interfaces;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *   语言设计者投入了大量精力来思考如何使现有的函数友好地支持lambda。最终采取的方法是：增加
 * 函数式接口的概念。函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换
 * 为lambda表达式。java.lang.Runnable与java.util.concurrent.Callable是函数式接口最典型
 * 的两个例子。在实际使用过程中，函数式接口是容易出错的：如有某个人在接口定义中增加了另一个
 * 方法，这时，这个接口就不再是函数式的了，并且编译过程也会失败。为了克服函数式接口的这种脆弱性
 * 并且能够明确声明接口作为函数式接口的意图，Java 8增加了一种特殊的注解@FunctionalInterface
 * （Java 8中所有类库的已有接口都添加了@FunctionalInterface注解）。让我们看一下这种函数式接口的定义：
 */
//@FunctionalInterface //这个注解类似@Override，若接口中不是唯一的抽象方法该注释会报错。
public interface Functional<T> {
    void method(T t);
}

/**
 * 测试自定义函数接口
 */
class FunctionalTest {

    private static void consumer(Functional<String> functional) {
        functional.method("测试");
    }

    public static void main(String[] args) {
        consumer(s -> {
            System.out.println(s);
            System.out.println();
        });
    }
}
