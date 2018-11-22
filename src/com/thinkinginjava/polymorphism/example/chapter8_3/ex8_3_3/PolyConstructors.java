package com.thinkinginjava.polymorphism.example.chapter8_3.ex8_3_3;

/**
 * @Author: monika
 * @Date: 2018/11/22 21:12
 * @Version: 1.0
 * @Description:   在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零。
 *
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
    private String string = "haha";
    RoundGlyph(int r,String s){
        radius = r;
        string = s;
        System.out.println("RoundGlyph.RoundGlyph(),radius = " + radius + " string = " + s);
    }
    @Override
    void draw(){
        System.out.println("RoundGlyph.draw(),radius = " + radius + " string = " + string);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5,"hello");
    }
}
/**输出：
 * Glyph() before draw()
 * RoundGlyph.draw(),radius = 0 string = null
 * Glyph() after draw()
 * RoundGlyph.RoundGlyph(),radius = 5 string = hello
 */