package com.thinkinginjava.string.exercise.chapter13_5;

/**
 * @Author: monika
 * @Date: 2019/1/1 14:57
 * @Version: 1.0
 * @Description: page 295
 * 练习06：创建一个包含int、long、float与double元素的类。应用String.format()方法为
 * 这个类编写toString()方法，并证明它能正确工作。
 */
class Test {
    int i = 0;
    long l = 0;
    float f = 0.0f;
    double d = 0.0;
    Test(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }
    public String toString() {
        return String.format("i = %d\nl = %d\nf = %.16g\nd = %.16g\n", i, l, f, d);
    }
}

public class Ex06 {
    public static void main(String[] args) {
        Test x = new Test(2, 45l, 1.2f, 2.7182818289);
        Test ex = new Test(-2147483648, -9223372036854775808L, 1.1754943508222875E-38f, 2.2250738585072014E-308);
        Test exMax = new Test(2147483647, 9223372036854775807L, 3.4028234663852886E38f, 1.7976931348623157E308);
        System.out.println(x);
        System.out.println(ex);
        System.out.println(exMax);
    }
}
/**output:
 * l = 45
 * f = 1.200000047683716
 * d = 2.718281828900000
 *
 * i = -2147483648
 * l = -9223372036854775808
 * f = 1.175494350822288e-38
 * d = 2.225073858507201e-308
 *
 * i = 2147483647
 * l = 9223372036854775807
 * f = 3.402823466385289e+38
 * d = 1.797693134862316e+308
 */
