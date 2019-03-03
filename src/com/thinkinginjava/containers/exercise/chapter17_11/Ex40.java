package com.thinkinginjava.containers.exercise.chapter17_11;

import com.thinkinginjava.util.Generator;
import com.thinkinginjava.util.RandomGenerator;

import java.util.*;

import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 21:50
 * @Version: 1.0
 * @Description: page 515
 * 练习40：创建一个包含两个String对象的类，并使其成为Comparable，因此，它们之间
 * 的比较只关心第一个String。通过使用RandomGenerator生成器，用这个类的对象填充
 * 一个数组和一个ArrayList。证明排序可以正确工作。现在创建一个只关心第二个String
 * 的Comparable，并证明排序仍旧可以正确工作。使用你的Comparator执行二分查找。
 */
class TwoStrings40 implements Comparable<TwoStrings40> {
    private String first = "";
    private String second = "";
    public TwoStrings40(String s1, String s2) {
        first = s1;
        second = s2;
    }
    // 仅使用第一个String进行比较：
    @Override
    public int compareTo(TwoStrings40 ts) {
        return first.compareTo(ts.first);
    }
    @Override
    public String toString() {
        return String.format("<%s & %s>", first, second);
    }
    public static void printArray(TwoStrings40[] sa) {
        printnb("(");
        for (int i = 0; i < sa.length - 1; i++)
            printnb(sa[i] + ", ");
        print(sa[sa.length - 1] + ")");
    }
    // 使用第二个String进行比较的可选内部类：
    public static class Comp2 implements Comparator<TwoStrings40> {
        @Override
        public int compare(TwoStrings40 ts1, TwoStrings40 ts2) {
            return ts1.second.compareTo(ts2.second);
        }
    }

    public static void main(String[] args) {
        RandomGenerator.String rgs = new RandomGenerator.String(4);
        TwoStrings40[] array = new TwoStrings40[5];
        List<TwoStrings40> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String s1 = rgs.next();
            String s2 = rgs.next();
            array[i] = new TwoStrings40(s1, s2);
            list.add(new TwoStrings40(s1, s2));
        }
        printnb("Array: ");
        TwoStrings40.printArray(array);
        print("List: " + list);
        print();

        Arrays.sort(array);
        Collections.sort(list, null);
        print("Sorted by first word:");
        printnb("Array: ");
        TwoStrings40.printArray(array);
        print("List: " + list);
        print();

        TwoStrings40.Comp2 comp = new TwoStrings40.Comp2();
        Arrays.sort(array, comp);
        Collections.sort(list, comp);
        print("Sorted by second word:");
        printnb("Array: ");
        TwoStrings40.printArray(array);
        print("List: " + list);
    }
}

public class Ex40 {
    public static void main(String[] args) {
        TwoStrings40.main(args);
    }
}
/**output:
 * Array: ({YNzb & rnyG}, {cFOW & ZnTc}, {QrGs & eGZM}, {mJMR & oEsu}, {EcUO & neOE})
 * List: [{YNzb & rnyG}, {cFOW & ZnTc}, {QrGs & eGZM}, {mJMR & oEsu}, {EcUO & neOE}]
 *
 * Sorted by first word:
 * Array: ({EcUO & neOE}, {QrGs & eGZM}, {YNzb & rnyG}, {cFOW & ZnTc}, {mJMR & oEsu})
 * List: [{EcUO & neOE}, {QrGs & eGZM}, {YNzb & rnyG}, {cFOW & ZnTc}, {mJMR & oEsu}]
 *
 * Sorted by second word:
 * Array: ({cFOW & ZnTc}, {QrGs & eGZM}, {EcUO & neOE}, {mJMR & oEsu}, {YNzb & rnyG})
 * List: [{cFOW & ZnTc}, {QrGs & eGZM}, {EcUO & neOE}, {mJMR & oEsu}, {YNzb & rnyG}]
 */