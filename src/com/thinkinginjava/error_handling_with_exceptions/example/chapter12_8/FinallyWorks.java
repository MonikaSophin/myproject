package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:19
 * @Version: 1.0
 * @Description:
 */
class ThreeException extends Exception {}

public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while(true){
            try{
                if (count++ == 0)
                    throw new ThreeException();
                System.out.println("No Exception");
            }catch (ThreeException e) {
                System.out.println("ThreeException");
            }finally {
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}
/**output:
 * ThreeException
 * In finally clause
 * No Exception
 * In finally clause
 */