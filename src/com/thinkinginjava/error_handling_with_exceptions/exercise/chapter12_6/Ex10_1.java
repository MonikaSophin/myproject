package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6;

/**
 * @Author: monika
 * @Date: 2018/12/27 23:58
 * @Version: 1.0
 * @Description: 练习10的另一个解法
 */
public class Ex10_1 {
    static void g() throws MyException4 {
        System.out.println("g()");
        throw new MyException4("throw MyException4 from g()");
    }

    static void f() {
        System.out.println("f()");
        try {
            try {
                g();
            } catch (MyException4 e1) {
                System.out.println("Caught MyException4 in f(), inner try: ");
                e1.printStackTrace(System.out);
                throw new MyException5("throw MyException5 from f(), inner try");
            }
        } catch (MyException5 e2) {
            System.out.println("Caught MyException5 in f(), outer try: ");
            e2.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        f();
    }
}
/**output:
 * f()
 * g()
 * Caught MyException4 in f(), inner try:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException4: throw MyException4 from g()
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10_1.g(Ex10_1.java:12)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10_1.f(Ex10_1.java:19)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10_1.main(Ex10_1.java:32)
 * Caught MyException5 in f(), outer try:
 * com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.MyException5: throw MyException5 from f(), inner try
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10_1.f(Ex10_1.java:23)
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_6.Ex10_1.main(Ex10_1.java:32)
 */