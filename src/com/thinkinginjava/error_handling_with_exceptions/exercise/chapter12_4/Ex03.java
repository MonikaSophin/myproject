package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:28
 * @Version: 1.0
 * @Description: page 253
 * 练习03：编写能产生并能捕获ArrayIndexOutOfBoundsException异常的代码。
 */
public class Ex03 {
    public static void main(String[] args) {
        int[] ints = new int[3];
        try{
            ints[5] = 5;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
/**output:
 * java.lang.ArrayIndexOutOfBoundsException: 5
 * 	at com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_4.Ex03.main(Ex03.java:14)
 */