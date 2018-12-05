package com.monika.jdk8.new_features_for_java.method_references;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/4
 * @description:
 *   方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。
 * 与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 *   下面，我们以定义了4个方法的Car这个类作为例子，区分Java中支持的4种不同的方法引用。
 */
public class MethodReferences {
    public static class Car{
        public static Car create(final Supplier<Car> supplier){
            return supplier.get();
        }
        public static void collide(final Car car){
            System.out.println("Collide " + car.toString());
        }
        public static void collide1(){
            System.out.println("Collide1 ");
        }
        public void follow(final Car another){
            System.out.println("Following the " + another.toString());
        }
        public void repair(){
            System.out.println("Repaired " + this.toString());
        }
        public void repair1(final Car car){
            System.out.println("Repaired1 " + this.toString());
        }

    }

    public static void main(String[] args) {
        //第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);

        //第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);
        //! cars.forEach(Car::collide1);

        //第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
        cars.forEach(Car::repair);
        //! cars.forEach(Car::repair1);

        //第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
        cars.forEach(police::repair1);
    }
}
/**输出：
 * Collide com.monika.jdk8.new_features_for_java.method_references.MethodReferences$Car@214c265e
 * Repaired com.monika.jdk8.new_features_for_java.method_references.MethodReferences$Car@214c265e
 * Following the com.monika.jdk8.new_features_for_java.method_references.MethodReferences$Car@214c265e
 * Repaired1 com.monika.jdk8.new_features_for_java.method_references.MethodReferences$Car@6d03e736
 */