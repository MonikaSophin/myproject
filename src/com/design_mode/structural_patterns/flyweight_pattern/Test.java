package com.design_mode.structural_patterns.flyweight_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤4:
 * 使用ShapeFactory，通过传递颜色信息来获取实体类的对象。
 */
public class Test {
    private static final String[] colors =
            { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomXY());
            circle.setY(getRandomXY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomXY() {
        return (int) (Math.random()*100);
    }
}
/**output(Sample):
 * Creating circle of color : Green
 * Circle: Draw() [Color : Green, x : 74, y :48, radius :100
 * Creating circle of color : Red
 * Circle: Draw() [Color : Red, x : 45, y :92, radius :100
 * Circle: Draw() [Color : Red, x : 94, y :2, radius :100
 * Circle: Draw() [Color : Red, x : 99, y :29, radius :100
 * Circle: Draw() [Color : Green, x : 31, y :60, radius :100
 * Circle: Draw() [Color : Green, x : 32, y :7, radius :100
 * Circle: Draw() [Color : Green, x : 45, y :52, radius :100
 * Creating circle of color : White
 * Circle: Draw() [Color : White, x : 75, y :22, radius :100
 * Circle: Draw() [Color : Red, x : 92, y :31, radius :100
 * Circle: Draw() [Color : White, x : 96, y :36, radius :100
 * Creating circle of color : Black
 * Circle: Draw() [Color : Black, x : 45, y :41, radius :100
 * Circle: Draw() [Color : White, x : 86, y :29, radius :100
 * Circle: Draw() [Color : Green, x : 87, y :88, radius :100
 * Circle: Draw() [Color : Green, x : 7, y :31, radius :100
 * Circle: Draw() [Color : Green, x : 88, y :72, radius :100
 * Creating circle of color : Blue
 * Circle: Draw() [Color : Blue, x : 54, y :71, radius :100
 * Circle: Draw() [Color : Blue, x : 37, y :5, radius :100
 * Circle: Draw() [Color : Green, x : 25, y :94, radius :100
 * Circle: Draw() [Color : Black, x : 30, y :96, radius :100
 * Circle: Draw() [Color : Green, x : 95, y :50, radius :100
 */