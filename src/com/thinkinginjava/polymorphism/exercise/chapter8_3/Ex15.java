package com.thinkinginjava.polymorphism.exercise.chapter8_3;

/**
 * @Author: monika
 * @Date: 2018/11/21 22:29
 * @Version: 1.0
 * @Description: page 164
 * 练习15：在PolyConstructors.java中添加一个RectangularGlyph,并证明会出现本节所描述的问题。
 */
class Glyph{
    void draw(){ System.out.println("Glyph.draw()"); }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(int),radius = " + radius);
    }
    @Override
    void draw(){ System.out.println("RoundGlyph.draw(),radius = " + radius); }
}

class RectangularGlyph extends Glyph {
    private int x = 2;
    private int y = 2;
    RectangularGlyph(int x,int y) {
        this.x = x;
        this.y = y;
        System.out.println("RectangularGlyph.RectangularGlyph(int,int),x = " + x +" y = " + y);
    }
    @Override
    void draw() { System.out.println("RectangularGlyph.draw(),x = " + x + " y = "+ y); }
}

public class Ex15 {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(3,3);
    }
}
/**输出：
 * Glyph() before draw()
 * RoundGlyph.draw(),radius = 0
 * Glyph() after draw()
 * RoundGlyph.RoundGlyph(int),radius = 5
 * Glyph() before draw()
 * RectangularGlyph.draw(),x = 0 y = 0
 * Glyph() after draw()
 * RectangularGlyph.RectangularGlyph(int,int),x = 3 y = 3
 */