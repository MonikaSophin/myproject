package com.thinkinginjava.containers.example.chapter17_8.ex17_8_3;

import java.util.LinkedHashMap;
import com.thinkinginjava.util.CountingMapData;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class LinkedHshMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(
                new CountingMapData(9));
        print(linkedMap);


        /**
         * 设置为LRU算法的LinkedHashMap版本，也是按照插入的顺序进行遍历的。
         */
        linkedMap = new LinkedHashMap<>(16, 075f, true);
        linkedMap.putAll(new CountingMapData(9));
        print("LRU版本:");
        print(linkedMap);

        /**
         *    在LRU版本中，在访问过前6个元素后，最后三个元素移到了队列前。
         * 然后再一次访问key为0的元素，它就被移到队列后端了。
         */
        for (int i = 0; i < 6; i++)
            linkedMap.get(i);
        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
}
/**output:
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
 * LRU版本:
 * {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
 * {6=G0, 7=H0, 8=I0, 0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0}
 * {6=G0, 7=H0, 8=I0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 0=A0}
 */