package com.monika.test.domain;

//用于 UnmodifiableMapTest示例中
public class Point {
    public int x;
    public int y;

    public Point(int x , int y) { setXY(x, y);}

    public void setXY(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x;}
    public int getY() { return y;}
    public String toString() { return "Point [x=" + x + ", y=" + y + "]";}
}
