package com.thinkinginjava.generics.example.chapter15_9;

import java.awt.*;

interface HasColor { Color getColor(); }

class Colored<T extends HasColor> {
  T item;
  Colored(T item) { this.item = item; }
  T getItem() { return item; }
  // The bound allows you to call a method:
  java.awt.Color color() { return item.getColor(); }
}

class Dimension { public int x, y, z; }

// 这不起作用 - 类必须是第一个，然后是接口:
// class ColoredDimension<T extends HasColor & Dimension> {
	
// 多重界限:
class ColoredDimension<T extends Dimension & HasColor> {
  T item;
  ColoredDimension(T item) { this.item = item; }
  T getItem() { return item; }
  java.awt.Color color() { return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
}

interface Weight { int weight(); }	

// 与继承一样，您只能拥有一个具体类但可以有多个接口:
class Solid<T extends Dimension & HasColor & Weight> {
  T item;
  Solid(T item) { this.item = item; }
  T getItem() { return item; }
  Color color() { return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
  int weight() { return item.weight(); }
}

class Bounded extends Dimension implements HasColor, Weight {
  public Color getColor() { return null; }
  public int weight() { return 0; }
}	

public class BasicBounds {
  public static void main(String[] args) {
    Solid<Bounded> solid =
      new Solid<>(new Bounded());
    solid.color();
    solid.getY();
    solid.weight();
  }
} ///:~
