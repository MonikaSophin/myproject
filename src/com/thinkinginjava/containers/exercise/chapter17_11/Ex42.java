package com.thinkinginjava.containers.exercise.chapter17_11;

import java.util.*;
import com.thinkinginjava.util.RandomGenerator;
import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 22:21
 * @Version: 1.0
 * @Description: page 515
 * 练习42：修改练习40，使其使用字母序排序。
 */
class TwoStrings42 implements Comparable<TwoStrings42> {
    private String first = "";
    private String second = "";
    public TwoStrings42(String s1, String s2) {
        first = s1;
        second = s2;
    }
    // 仅使用第一个String进行比较:
    @Override
    public int compareTo(TwoStrings42 ts) {
        return first.compareToIgnoreCase(ts.first);
    }

    @Override
    public String toString() {
        return String.format("<%s & %s>", first, second);
    }
    static void printArray(TwoStrings42[] sa) {
        printnb("(");
        for(int i = 0; i < sa.length - 1; i++)
            printnb(sa[i] + ", ");
        print(sa[sa.length - 1] + ")");
    }
    // 可选的内部类，使用第二个String进行比较:
    public static class Comp2 implements Comparator<TwoStrings42> {
        @Override
        public int compare(TwoStrings42 ts1, TwoStrings42 ts2) {
            return ts1.second.compareToIgnoreCase(ts2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        TwoStrings42[] array = new TwoStrings42[5];
        List<TwoStrings42> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            array[i] = new TwoStrings42(s1, s2);
            list.add(new TwoStrings42(s1, s2));
        }
        printnb("Array: ");
        printArray(array);
        print("List: " + list);
        print();

        Arrays.sort(array);
        Collections.sort(list, null);
        print("Sorted by first word:");
        printnb("Array: ");
        printArray(array);
        print("List: " + list);
        print();

        TwoStrings42.Comp2 comp = new TwoStrings42.Comp2();
        Arrays.sort(array, comp);
        Collections.sort(list, comp);
        print("Sorted by second word:");
        printnb("Array: ");
        printArray(array);
        print("List: " + list);
    }
}

public class Ex42 {
    public static void main(String[] args) {
        TwoStrings42.main(args);
    }
}
/**output:
 * Array: (<YNzb & rnyG>, <cFOW & ZnTc>, <QrGs & eGZM>, <mJMR & oEsu>, <EcUO & neOE>)
 * List: [<YNzb & rnyG>, <cFOW & ZnTc>, <QrGs & eGZM>, <mJMR & oEsu>, <EcUO & neOE>]
 *
 * Sorted by first word:
 * Array: (<cFOW & ZnTc>, <EcUO & neOE>, <mJMR & oEsu>, <QrGs & eGZM>, <YNzb & rnyG>)
 * List: [<cFOW & ZnTc>, <EcUO & neOE>, <mJMR & oEsu>, <QrGs & eGZM>, <YNzb & rnyG>]
 *
 * Sorted by second word:
 * Array: (<QrGs & eGZM>, <EcUO & neOE>, <mJMR & oEsu>, <YNzb & rnyG>, <cFOW & ZnTc>)
 * List: [<QrGs & eGZM>, <EcUO & neOE>, <mJMR & oEsu>, <YNzb & rnyG>, <cFOW & ZnTc>]
 */