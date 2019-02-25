package com.thinkinginjava.containers.exercise.chapter17_6;

import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.RandomGenerator;
import java.util.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description: page 480
 * 练习09：使用RandomGenerator.String来填充TreeSet，但是要使用字母序排序。打印这
 * 个TreeSet，并验证其排序顺序。
 */
public class Ex09 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        List<String> list = Arrays.asList(
                Generated.array(new String[10], new RandomGenerator.String(5)));
        set.addAll(list);
        System.out.println(set);
    }
}
/**output:
 * [cQrGs, dLsmw, eGZMm, HLGEa, JMRoE, nyGcF, OneOE, OWZnT, suEcU, YNzbr]
 */