package com.thinkinginjava.enumerated_types.example.chapter19_1.ex19_1_1;

import static com.thinkinginjava.enumerated_types.example.chapter19_1.ex19_1_1.Spiciness.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/1
 * @description:
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree; }
    @Override
    public String toString() { return "Burrito is " + degree; }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
/**output:
 * Burrito is NOT
 * Burrito is MEDIUM
 * Burrito is HOT
 */
