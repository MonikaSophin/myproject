package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_8.ex12_8_1;

/**
 * @Author: monika
 * @Date: 2018/12/28 22:38
 * @Version: 1.0
 * @Description:
 */
class FourException extends Exception {}

public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try{
            System.out.println("Entering second try block");
            try{
                throw new FourException();
            }finally {
                System.out.println("finally in 2nd try block");
            }
        }catch (FourException e){
            System.out.println("Caught FourException in 1st try block");
        }finally {
            System.out.println("finally in 1st try block");
        }
    }
}
/**output:
 * Entering first try block
 * Entering second try block
 * finally in 2nd try block
 * Caught FourException in 1st try block
 * finally in 1st try block
 */