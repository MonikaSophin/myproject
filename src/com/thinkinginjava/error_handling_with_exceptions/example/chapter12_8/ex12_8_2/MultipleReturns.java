package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_2;

/**
 * @Author: monika
 * @Date: 2018/12/28 23:12
 * @Version: 1.0
 * @Description:
 * 1.在一个方法中，无论多个点返回，finally块终会执行。
 */
public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if (i == 1) return;
            System.out.println("Point 2");
            if (i == 2) return;
            System.out.println("Point 3");
            if (i == 3) return;
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++)
            f(i);
    }
}
/**output:
 * Initialization that requires cleanup
 * Point 1
 * Performing cleanup
 * Initialization that requires cleanup
 * Point 1
 * Point 2
 * Performing cleanup
 * Initialization that requires cleanup
 * Point 1
 * Point 2
 * Point 3
 * Performing cleanup
 * Initialization that requires cleanup
 * Point 1
 * Point 2
 * Point 3
 * End
 * Performing cleanup
 */