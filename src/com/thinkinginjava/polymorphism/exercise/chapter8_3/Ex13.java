package com.thinkinginjava.polymorphism.exercise.chapter8_3;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:57
 * @Version: 1.0
 * @Description: page 162
 * 练习13: 在ReferenceCounting.java中添加一个fianlize()方法，用来校验终止条件（查看第5章）。
 */
class Shared{
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared() {
        System.out.println("Creating " + this);
    }
    public void addRef(){refcount++;}
    protected void dispose(){
        System.out.println("当前被引用计数: "+refcount);
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }
    @Override
    protected void finalize(){
        if (refcount>0) {
            System.out.println("Error: " + refcount +
                    " Shared[" + id + "] objects in use");
        }
    }
    @Override
    public String toString() { return "Shared[" + id +"]"; }
}

class Composing{
    private Shared shared ;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("Disposing " + this);
        shared.dispose();
    }
    @Override
    public String toString() { return "Composing[" + id + "]"; }
}

class RefenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared),
                new Composing(shared),new Composing(shared),
                new Composing(shared),new Composing(shared)};
        for (Composing c : composings)
            c.dispose();

        Composing compTest = new Composing(shared);
        Composing compTest2 = new Composing(shared);
        // compTest.dispose();compTest2.dispose();
        // Test finalize():
        shared.finalize();

        Shared sharedTest = new Shared();
        Composing compTest3 = new Composing(sharedTest);
        // Test sharedTest finalize():
        sharedTest.finalize();
    }

}

public class Ex13 {}
