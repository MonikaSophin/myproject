package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_8;

/**
 * @Author: monika
 * @Date: 2018/12/28 23:36
 * @Version: 1.0
 * @Description: page 269
 * 练习18：为LostMessage.java添加第二层异常丢失，以便用第三个异常来替代HoHumException异常。
 */
class VeryImportantException extends Exception {
    public String toString() { return "VeryImportantException!"; }
}

class HoHumException extends Exception {
    public String toString() { return "HoHumException!"; }
}

class MeaninglessException extends Exception {
    public String toString() { return "MeaninglessException!"; }
}

public class Ex18 {
    void f() throws VeryImportantException { throw new VeryImportantException(); }
    void dispose() throws HoHumException { throw new HoHumException(); }
    void eliminate() throws MeaninglessException { throw new MeaninglessException(); }

    public static void main(String[] args) {
        try {
            Ex18 ex18 = new Ex18();
            try {
                try {
                    ex18.f();//1.从此处开始抛出异常。
                    ex18.dispose();
                } finally {
                    ex18.eliminate();//2.执行到finally块时，抛出第三个异常
                }
            } catch(Exception e) {
                System.out.println(e);//3.捕获到第三个异常，输出异常
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("程序结束!");//4.结束程序。
    }
}
/**output:
 * MeaninglessException!
 * 程序结束!
 */