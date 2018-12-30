package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12;

/**
 * @Author: monika
 * @Date: 2018/12/30 17:35
 * @Version: 1.0
 * @Description: page 281
 * 练习30：修改Human.java，使异常继承自RuntimeException修改main()，使其用
 * TurnOffChecking.java类处理不同类型的异常。
 */
class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}

class WrapCheckedExceptions {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case (0):
                    throw new Annoyance();
                case (1):
                    throw new Sneeze();
                case (2):
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            //用RuntimeException进行包装：
            throw new RuntimeException(e);
        }
    }
}

public class Ex30 {
    public static void main(String[] args) {
        WrapCheckedExceptions wce = new WrapCheckedExceptions();

        for (int i = 0; i <= 4; i++)
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new RuntimeException();
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();//当'i>=3'时，cause为null。
                } catch (Sneeze e) {
                    System.out.println("Sneeze: " + e);
                } catch (Annoyance e) {
                    System.out.println("Annoyance: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
    }
}
/**output:
 * Annoyance: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Annoyance
 * Sneeze: com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12.Sneeze
 * Throwable: java.lang.RuntimeException: Where am I?
 * Throwable: java.lang.NullPointerException
 * Throwable: java.lang.NullPointerException
 */