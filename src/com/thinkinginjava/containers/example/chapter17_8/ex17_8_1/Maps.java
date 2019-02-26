package com.thinkinginjava.containers.example.chapter17_8.ex17_8_1;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.thinkinginjava.util.CountingMapData;
import static com.thinkinginjava.util.Print.*;
/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map) {
        printnb(String.format("Size = %s. ", map.size()));
        print(String.format("keys : %s", map.keySet()));
    }
    public static void test(Map<Integer, String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(10));
        map.putAll(new CountingMapData(10));

        printKeys(map);
        print(String.format("Values: %s", map.values()));
        print(map);

        print(String.format("map.containsKey(1): %s", map.containsKey(1)));
        print(String.format("map.get(1): %s", map.get(1)));
        print(String.format("map.containsValue(\"F0\"): %s", map.containsValue("F0")));

        Integer key = map.keySet().iterator().next();
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
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
    }
}
/**output:
 * HashMap
 * Size = 10. keys : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): true
 * First_key_in_map: 0
 * Size = 9. keys : [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * TreeMap
 * Size = 10. keys : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): true
 * First_key_in_map: 0
 * Size = 9. keys : [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * LinkedHashMap
 * Size = 10. keys : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): true
 * First_key_in_map: 0
 * Size = 9. keys : [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * IdentityHashMap
 * Size = 10. keys : [0, 6, 1, 2, 8, 7, 5, 3, 4, 9]
 * Values: [A0, G0, B0, C0, I0, H0, F0, D0, E0, J0]
 * {0=A0, 6=G0, 1=B0, 2=C0, 8=I0, 7=H0, 5=F0, 3=D0, 4=E0, 9=J0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): false
 * First_key_in_map: 0
 * Size = 9. keys : [6, 1, 2, 8, 7, 5, 3, 4, 9]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * ConcurrentHashMap
 * Size = 10. keys : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0]
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 * map.containsKey(1): true
 * map.get(1): B0
 * map.containsValue("F0"): true
 * First_key_in_map: 0
 * Size = 9. keys : [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * map.isEmpty(): true
 * map.isEmpty(): true
 *
 * WeakHashMap
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