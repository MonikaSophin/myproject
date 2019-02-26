package com.thinkinginjava.containers.exercise.chapter17_8;

import com.thinkinginjava.containers.example.chapter17_8.ex17_8_1.Maps;
import com.thinkinginjava.util.CountingMapData;

import java.util.Map;
import java.util.Properties;
import static com.thinkinginjava.util.Print.print;
import static com.thinkinginjava.util.Print.printnb;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description: page 486
 * 练习14：说明java.util.Properties在上面的程序中可以工作。
 */
public class Ex14 {
    public static void printKeys(Map<Object, Object> map) {
        printnb(String.format("Size = %s. ", map.size()));
        print(String.format("keys : %s", map.keySet()));
    }
    public static void test(Map<Object, Object> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(10));
        map.putAll(new CountingMapData(10));

        printKeys(map);
        print(String.format("Values: %s", map.values()));
        print(map);

        print(String.format("map.containsKey(1): %s", map.containsKey(1)));
        print(String.format("map.get(1): %s", map.get(1)));
        print(String.format("map.containsValue(\"F0\"): %s", map.containsValue("F0")));

        Object key = map.keySet().iterator().next();
        print(String.format("First_key_in_map: %s", key));

        map.remove(key);
        printKeys(map);
        map.clear();
        print(String.format("map.isEmpty(): %s", map.isEmpty()));

        map.putAll(new CountingMapData(10));
        map.keySet().removeAll(map.keySet());
        print(String.format("map.isEmpty(): %s", map.isEmpty()));
        print();
    }

    public static void main(String[] args) {
        /**
         * 编译错误：
         * 在Maps的test(java.util.Map<java.lang.Integer,java.lang.String>)方法
         * 无法应用于(java.util.Properties)
         */
        //! Maps.test(new Properties());
        test(new Properties());
    }
}
/**output:
 * Properties
 * Size = 10. keys : [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
 * Values: [J0, I0, H0, G0, F0, E0, D0, C0, B0, A0]
 * {9=J0, 8=I0, 7=H0, 6=G0, 5=F0, 4=E0, 3=D0, 2=C0, 1=B0, 0=A0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): true
 * First_key_in_map: 9
 * Size = 9. keys : [8, 7, 6, 5, 4, 3, 2, 1, 0]
 * map.isEmpty(): true
 * map.isEmpty(): true
 */