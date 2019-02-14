package com.thinkinginjava.generics.example.chapter15_10;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;
import com.thinkinginjava.generics.example.chapter15_10.model.Jonathan;
import com.thinkinginjava.generics.example.chapter15_10.model.Orange;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 * 形式定义:
 *  在一门程序设计语言的类型系统中，一个类型规则或者类型构造器是：
 *  -协变（covariant），如果它保持了子类型序关系≦。该序关系是：子类型≦基类型。
 *  -逆变（contravariant），如果它逆转了子类型序关系。
 *  -不变（invariant），如果上述两种均不适用。
 *
 * 数组:
 *  首先考虑数组类型构造器： 从Animal类型，可以得到Animal[]（“animal数组”）。
 *  -协变：一个Cat[]也是一个Animal[]
 *  -逆变：一个Animal[]也是一个Cat[]
 *  -以上二者均不是（不变）？
 *  如果要避免类型错误，且数组支持对其元素的读、写操作，那么只有第3个选择是安全的。
 *  Animal[]并不是总能当作Cat[]，因为当一个客户读取数组并期望得到一个Cat，但Animal[]中包含的可能是个Dog。所以逆变规则是不安全的。
 * 反之，一个Cat[]也不能被当作一个Animal[]。因为总是可以把一个Dog放到Animal[]中。在协变数组，这就不能保证是安全的，因为背后的存储可以实际是Cat[]。因此协变规则也不是安全的—数组构造器应该是不变。
 * 注意，这仅是可写（mutable）数组的问题；对于不可写（只读）数组，协变规则是安全的。
 * 这示例了一般现像。只读数据类型（源）是协变的；只写数据类型（汇/sink）是逆变的。可读可写类型应是“不变”的。
 *
 * 有关覆写方法的规则:
 *  参数类型	返回类型
 * 	 不变	  协变
 */
public class CoveriantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        // 运行时类型是Apple[] 不是Fruit[]或Orange[]
        try {
            // 在编译时允许你向数组中添加Fruit
            fruits[0] = new Fruit(); // ArrayStoreException
        }catch (Exception e) {
            System.out.println(e);
        }
        try {
            // 在编译时允许你向数组中添加Orange
            fruits[0] = new Orange(); // ArrayStoreException
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
/**output:
 * java.lang.ArrayStoreException: com.thinkinginjava.generics.example.chapter15_10.model.Fruit
 * java.lang.ArrayStoreException: com.thinkinginjava.generics.example.chapter15_10.model.Orange
 */
