package com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2;

/**
 * @Author: monika
 * @Date: 2018/11/19 21:22
 * @Version: 1.0
 * @Description:   * 将一个方法调用同一个方法主体关联起来被称作绑定。
 *               前期绑定：若在程序执行前进行绑定（如果有的话，由编译器和连接程序实现）。
 *               后期绑定：就是在运行时根据对象的类型进行绑定。也被称作动态绑定或运行时绑定。
 *                 * java中除了static方法和final方法（private方法属于final方法）之外，
 *                 其他所有的方法都是后期绑定的。这意味着通常情况下，我们不必判定是否应该
 *                 进行后期绑定————它会自动发生。
 */
public class Shapes {
    private static RandomShapeGenerator gen =
            new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        // Fill up the array with shapes:
        for(int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // Make polymorphic method calls:
        for(Shape shp : s)
            shp.draw();
    }
}
/** Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
*/
