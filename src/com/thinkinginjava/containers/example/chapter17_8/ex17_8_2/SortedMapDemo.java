package com.thinkinginjava.containers.example.chapter17_8.ex17_8_2;

import java.util.Iterator;
import java.util.TreeMap;
import com.thinkinginjava.util.CountingMapData;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(
                new CountingMapData(10));
        print(sortedMap);

        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        print(low);
        print(high);

        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3)
                low = it.next();
            if (i == 6)
                high = it.next();
            else
                it.next();
        }
        print(low);
        print(high);

        print(sortedMap.subMap(low, high));
        print(sortedMap.headMap(high));
        print(sortedMap.tailMap(low));
    }
}
/**output:
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 * 0
 * 9
 * 3
 * 7
 * {3=D0, 4=E0, 5=F0, 6=G0}
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0}
 * {3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
 */