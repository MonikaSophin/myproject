package com.monika.jdk8.new_features_for_java.better_type_inference_mechanism;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *    Java 8在类型推测方面有了很大的提高。在很多情况下，编译器可以推测出确定的参数类型，这样就能使代码更整洁。
 * 让我们看一个例子：
 */
public class TypeInference {
    //这里是Value<String>类型的用法。
    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        /**
         *    Value.defaultValue()的参数类型可以被推测出，所以就不必明确给出。在Java 7中，
         * 相同的例子将不会通过编译，正确的书写方式是 Value.<String>defaultValue()。
         */
        value.getOrDefault("22",Value.defaultValue());
    }
}
