package com.thinkinginjava.polymorphism.example.chapter8_3.ex8_3_2;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:29
 * @Version: 1.0
 * @Description:
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
    public String toString() {
        return "Shared[" + id +"]";
    }
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
    public String toString() {
        return "Composing[" + id + "]";
    }
}

public class RefenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared),
                new Composing(shared),new Composing(shared),
                new Composing(shared),new Composing(shared)};
        for (Composing c : composings)
            c.dispose();
    }
}
/**输出：
 * Creating Shared[0]
 * Creating Composing[0]
 * Creating Composing[1]
 * Creating Composing[2]
 * Creating Composing[3]
 * Creating Composing[4]
 * Disposing Composing[0]
 * 当前被引用计数: 5
 * Disposing Composing[1]
 * 当前被引用计数: 4
 * Disposing Composing[2]
 * 当前被引用计数: 3
 * Disposing Composing[3]
 * 当前被引用计数: 2
 * Disposing Composing[4]
 * 当前被引用计数: 1
 * Disposing Shared[0]
 */