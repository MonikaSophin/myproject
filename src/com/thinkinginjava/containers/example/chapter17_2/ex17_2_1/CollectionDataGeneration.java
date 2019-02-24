package com.thinkinginjava.containers.example.chapter17_2.ex17_2_1;

import com.thinkinginjava.util.CollectionData;
import com.thinkinginjava.util.RandomGenerator;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: monika
 * @Date: 2019/2/24 17:49
 * @Version: 1.0
 * @Description:
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList(
                CollectionData.list(new RandomGenerator.String(9), 10)
        ));
        System.out.println(new HashSet<>(
                new CollectionData<>(new RandomGenerator.Integer(), 10)
        ));
    }
}
/**output:
 * [YNzbrnyGc, FOWZnTcQr, GseGZMmJM, RoEsuEcUO, neOEdLsmw, HLGEahKcx, rEqUCBbkI, naMesbtWH, kjUrUkZPg, wsqPzDyCy]
 * [2017, 8037, 871, 7882, 6090, 4779, 299, 573, 4367, 3455]
 */