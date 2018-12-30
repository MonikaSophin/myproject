package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_4;

/**
 * @Author: monika
 * @Date: 2018/12/26 22:08
 * @Version: 1.0
 * @Description:
 */
class SimpleException extends Exception{}

public class InheritingException {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}
/**output:
 * Throw SimpleException from f()
 * Caught it!
 */