package com.thinkinginjava.concurrency.example.ex21_2_1;

/**
 * page  654
 */
public class MainThread {
    public static void main(String[] args){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
/**
 * 输出 ：
 * main>> #0[9].
 * main>> #0[8].
 * main>> #0[7].
 * main>> #0[6].
 * main>> #0[5].
 * main>> #0[4].
 * main>> #0[3].
 * main>> #0[2].
 * main>> #0[1].
 * main>> #0[Liftoff!].
 */