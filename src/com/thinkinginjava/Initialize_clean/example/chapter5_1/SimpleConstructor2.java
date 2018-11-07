package com.thinkinginjava.Initialize_clean.example.chapter5_1;

/**
 * @Author: monika
 * @Date: 2018/11/7 22:06
 * @Version: 1.0
 * @Description:
 */
class Rock2 {
    public Rock2(int i) {
        System.out.print("Rock" + i + " ");
    }
}

public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}
/**输出：
 *Rock0 Rock1 Rock2 Rock3 Rock4 Rock5 Rock6 Rock7
 */