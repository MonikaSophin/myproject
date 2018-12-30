package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6;

/**
 * @Author: monika
 * @Date: 2018/12/27 21:41
 * @Version: 1.0
 * @Description:
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e.toString());
            System.out.print("printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }
}
/**output:
 * Caught Exception
 * getMessage(): My Exception
 * getLocalizedMessage(): My Exception
 * toString(): java.lang.Exception: My Exception
 * printStackTrace(): java.lang.Exception: My Exception
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_6.ExceptionMethods.main(ExceptionMethods.java:12)
 */