package com.thinkinginjava.polymorphism.example.chapter8_5;

/**
 * @Author: monika
 * @Date: 2018/11/22 21:57
 * @Version: 1.0
 * @Description:
 */
class Actor {
    public void act() {}
}

class HappyActor extends Actor {
    public void act() { System.out.println("HappyActor"); }
}

class SadActor extends Actor {
    public void act() { System.out.println("SadActor"); }
}

class Stage {
    private Actor actor = new HappyActor();
    public void change() { actor = new SadActor(); }
    public void performPlay() { actor.act(); }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
/** Output:
HappyActor
SadActor
*/
