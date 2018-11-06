package com.thinkinginjava.controlling_execution.example.chapter4_7;

/**
 * @Author: monika
 * @Date: 2018/11/6 22:00
 * @Version: 1.0
 * @Description:
 *                （1） 一般的continue会退回最内层的循环的开头(顶部)，并继续执行。
 *                （2） 带标签的continue会到达标签的位置，并重新进入紧接在那个标签后面的循环。
 *                （3） 一般的break会中断兵跳出当前循环。
 *                （4） 带标签的break会中断并跳出标签所指的循环。
 *
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outer:
        for (; true; ) {
            inner:
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
/**输出：
 * i = 0
 * continue inner
 * i = 1
 * continue inner
 * i = 2
 * continue
 * i = 3
 * break
 * i = 4
 * continue inner
 * i = 5
 * continue inner
 * i = 6
 * continue inner
 * i = 7
 * continue outer
 * i = 8
 * break outer
 */
