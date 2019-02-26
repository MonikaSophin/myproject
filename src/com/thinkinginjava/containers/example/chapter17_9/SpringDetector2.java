package com.thinkinginjava.containers.example.chapter17_9;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class SpringDetector2 {
    public static void main(String[] args) throws Exception {
        SpringDetector.detectSpring(Groundhog2.class);
    }
}
/**output:
 * map = {Groundhog #0=Six more weeks of winter, Groundhog #1=Six more weeks of winter, Groundhog #2=Early Spring, Groundhog #3=Early Spring, Groundhog #4=Six more weeks of winter, Groundhog #5=Early Spring, Groundhog #6=Early Spring, Groundhog #7=Early Spring, Groundhog #8=Six more weeks of winter, Groundhog #9=Six more weeks of winter}
 * Looking_up_prediction_for Groundhog #3
 * Early Spring
 */