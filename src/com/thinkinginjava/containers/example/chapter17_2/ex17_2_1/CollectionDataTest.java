package com.thinkinginjava.containers.example.chapter17_2.ex17_2_1;

import com.thinkinginjava.util.CollectionData;
import com.thinkinginjava.util.Generator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: monika
 * @Date: 2019/2/24 17:44
 * @Version: 1.0
 * @Description:
 */
class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");
    private int index;
    @Override
    public String next() { return foundation[index++]; }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Government(), 15)
        );
        System.out.println(set);

        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);

    }
}
/**output:
 * [strange, women, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
 * [strange, women, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
 */