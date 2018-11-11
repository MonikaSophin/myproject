package com.thinkinginjava.Initialize_clean.example.chapter5_8;

/**
 * @Author: monika
 * @Date: 2018/11/11 17:07
 * @Version: 1.0
 * @Description:
 */
class Other {
    public static void main(String[] args) {
        for(String s : args)
            System.out.print(s + " ");
    }
}
public class DynamicArray {
    public static void main(String[] args) {
        Other.main(new String[]{ "fiddle", "de", "dum" });
    }
}

/**输出：
 * fiddle de dum
 */