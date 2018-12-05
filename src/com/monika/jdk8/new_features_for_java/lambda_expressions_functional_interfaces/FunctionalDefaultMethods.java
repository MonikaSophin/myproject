package com.monika.jdk8.new_features_for_java.lambda_expressions_functional_interfaces;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *  需要记住的一件事是：默认方法与静态方法(jdk1.8开始interface开始支持)并不影响函数式接口的契约，可以任意使用：
 */
@FunctionalInterface
public interface FunctionalDefaultMethods {
    void method();
    //默认方法
    default void defaultMethod(){
        //方法体
    }
    //静态方法
    static void staticMethod(){
        //方法体
    }
}
