package com.thinkinginjava.arrays.example.chapter16_7.ex16_7_1;

import java.util.Arrays;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description:
 * {@link System#arraycopy(Object, int, Object, int, int)}：
 * 用它复制数组比用for循环复制要快很多。System.arraycopy对所有类型做了重载。
 *
 * 如果复制对象数组，那么只是复制了对象的引用，而不是对象本身的拷贝。这被称为“浅复制”。
 * System.arraycopy() 不会执行自动包装盒自动拆包，两个数组必须具有相同的确切类型。
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        print(String.format("int[] i = %s", Arrays.toString(i)));
        print(String.format("int[] j = %s", Arrays.toString(j)));

        System.arraycopy(i, 0, j, 0, i.length);
        print(String.format("copy: int[] j = %s", Arrays.toString(j)));

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        print(String.format("copy: int[] k = %s", Arrays.toString(k)));

        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        print(String.format("copy: int[] i = %s", Arrays.toString(i)));
        System.out.println();

        //objects
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, 47);
        Arrays.fill(v, 99);
        print(String.format("int[] u = %s", Arrays.toString(u)));
        print(String.format("int[] v = %s", Arrays.toString(v)));
        System.arraycopy(v, 0, u, u.length/2, v.length);
        print(String.format("copy: int[] u = %s", Arrays.toString(u)));

        /**
         *  System.arraycopy() 不会执行自动包装盒自动拆包，两个数组必须具有相同的确切类型。
         */
        // 编译不会报错。运行时异常java.lang.ArrayStoreException
        // System.arraycopy(u, 0, k, 0, k.length);
    }
}
/**output:
 * int[] i = [47, 47, 47, 47, 47, 47, 47]
 * int[] j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
 * copy: int[] j = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
 * copy: int[] k = [47, 47, 47, 47, 47]
 * copy: int[] i = [103, 103, 103, 103, 103, 47, 47]
 *
 * int[] u = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
 * int[] v = [99, 99, 99, 99, 99]
 * copy: int[] u = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
 */