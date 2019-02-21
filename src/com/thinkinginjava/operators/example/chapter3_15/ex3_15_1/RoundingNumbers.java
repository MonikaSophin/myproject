package com.thinkinginjava.operators.example.chapter3_15.ex3_15_1;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 17:55
 * @Version: 1.0
 * @Description: Math.round(); -->四舍五入
 *               Math.floor(); -->向下取整
 *               Math.ceil();  -->向上取整
 */
public class RoundingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        Print.print("四舍五入:");
        Print.print("Math.round(above): " + Math.round(above));
        Print.print("Math.round(below): " + Math.round(below));
        Print.print("Math.round(fabove): " + Math.round(fabove));
        Print.print("Math.round(fbelow): " + Math.round(fbelow));
        Print.print("向上取整:");
        Print.print("Math.ceil(above): " + Math.ceil(above));
        Print.print("Math.ceil(below): " + Math.ceil(below));
        Print.print("Math.ceil(fabove): " + Math.ceil(fabove));
        Print.print("Math.ceil(fbelow): " + Math.ceil(fbelow));
        Print.print("向下取整:");
        Print.print("Math.floor(above): " + Math.floor(above));
        Print.print("Math.floor(below): " + Math.floor(below));
        Print.print("Math.floor(fabove): " + Math.floor(fabove));
        Print.print("Math.floor(fbelow): " + Math.floor(fbelow));

    }
}
/**输出：
 *
 * 四舍五入:
 * Math.round(above): 1
 * Math.round(below): 0
 * Math.round(fabove): 1
 * Math.round(fbelow): 0
 * 向上取整:
 * Math.ceil(above): 1.0
 * Math.ceil(below): 1.0
 * Math.ceil(fabove): 1.0
 * Math.ceil(fbelow): 1.0
 * 向下取整:
 * Math.floor(above): 0.0
 * Math.floor(below): 0.0
 * Math.floor(fabove): 0.0
 * Math.floor(fbelow): 0.0
 */
