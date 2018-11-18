package com.thinkinginjava.reusing_classes.example.chapter7_3;

/**
 * @Author: monika
 * @Date: 2018/11/15 21:54
 * @Version: 1.0
 * @Description:
 */
public class SpaceShip extends SpaceShipControls {
    private String name;
    public SpaceShip(String name) { this.name = name; }
    public String toString() { return name; }
    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
