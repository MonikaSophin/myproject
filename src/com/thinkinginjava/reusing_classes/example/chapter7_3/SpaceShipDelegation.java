package com.thinkinginjava.reusing_classes.example.chapter7_3;

/**
 * @Author: monika
 * @Date: 2018/11/15 21:54
 * @Version: 1.0
 * @Description:  Delegation:代理
 *  第三种关系成为代理。java并没有对它的直接支持。这是继承与组合之间的中庸之道，
 *  因为我们将一个成员对象置于所要构造的类中（就像组合），但与此同时我们在新类中
 *  暴露了该成员对象的所有方法（就像继承）。例如：太空船需要一个控制模块。
 *
 *    这个例子很形象：太空船的控制模块在太空船内部，控制太空船的核心动作。
 *  但又不能让外部发现这个核心控制模块。所以将控制模块这个部分给private，
 *  并对外提供获取太空船动作的方法。实际上还是调用控制模块的方法。
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls =
            new SpaceShipControls();
    public SpaceShipDelegation(String name) {
        this.name = name;
    }
    // Delegated methods:
    public void back(int velocity) {
        controls.back(velocity);
    }
    public void down(int velocity) {
        controls.down(velocity);
    }
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    public void left(int velocity) {
        controls.left(velocity);
    }
    public void right(int velocity) {
        controls.right(velocity);
    }
    public void turboBoost() {
        controls.turboBoost();
    }
    public void up(int velocity) {
        controls.up(velocity);
    }
    public static void main(String[] args) {
        SpaceShipDelegation protector =
                new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
}
