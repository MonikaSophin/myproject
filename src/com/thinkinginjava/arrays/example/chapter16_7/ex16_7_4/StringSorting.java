package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_4;

import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.RandomGenerator;
import static com.thinkinginjava.util.Print.print;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description:
 *    使用内置的排序方法，就可以对任意的基本类型数组排序；也可以对任意的对象数组
 *  进行排序，只要该对象实现了Comparable接口或具有相关联的Comparator。
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] a = Generated.array(
                new String[20], new RandomGenerator.String(5));
        print("before sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a, Collections.reverseOrder());
        print("reverse sorting:");
        print(Arrays.toString(a));

        // 忽略大小写
        Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
        print("CASE_INSENSITIVE_ORDER sorting:");
        print(Arrays.toString(a));
    }
}
/**output:
 * before sorting:
 * [YNzbr, nyGcF, OWZnT, cQrGs, eGZMm, JMRoE, suEcU, OneOE, dLsmw, HLGEa, hKcxr, EqUCB, bkIna, Mesbt, WHkjU, rUkZP, gwsqP, zDyCy, RFJQA, HxxHv]
 * after sorting:
 * [EqUCB, HLGEa, HxxHv, JMRoE, Mesbt, OWZnT, OneOE, RFJQA, WHkjU, YNzbr, bkIna, cQrGs, dLsmw, eGZMm, gwsqP, hKcxr, nyGcF, rUkZP, suEcU, zDyCy]
 * reverse sorting:
 * [zDyCy, suEcU, rUkZP, nyGcF, hKcxr, gwsqP, eGZMm, dLsmw, cQrGs, bkIna, YNzbr, WHkjU, RFJQA, OneOE, OWZnT, Mesbt, JMRoE, HxxHv, HLGEa, EqUCB]
 * CASE_INSENSITIVE_ORDER sorting:
 * [bkIna, cQrGs, dLsmw, eGZMm, EqUCB, gwsqP, hKcxr, HLGEa, HxxHv, JMRoE, Mesbt, nyGcF, OneOE, OWZnT, RFJQA, rUkZP, suEcU, WHkjU, YNzbr, zDyCy]
 */