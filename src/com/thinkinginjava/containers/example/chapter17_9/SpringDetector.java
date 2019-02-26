package com.thinkinginjava.containers.example.chapter17_9;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i), new Prediction());
        print(String.format("map = %s", map));

        Groundhog gh = ghog.newInstance(3); //散列码不同于前一个
        print(String.format("Looking_up_prediction_for %s", gh));
        if (map.containsKey(gh))
            print(map.get(gh));
        else
            print(String.format("Key_not_found: %s", gh));
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
/**output:
 * map = {Groundhog #9=Six more weeks of winter, Groundhog #0=Six more weeks of winter, Groundhog #2=Early Spring, Groundhog #5=Early Spring, Groundhog #7=Early Spring, Groundhog #4=Six more weeks of winter, Groundhog #6=Early Spring, Groundhog #1=Six more weeks of winter, Groundhog #3=Early Spring, Groundhog #8=Six more weeks of winter}
 * Looking_up_prediction_for Groundhog #3
 * Key_not_found: Groundhog #3
 */