package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_12.ex12_12_4;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: monika
 * @Date: 2018/12/30 20:31
 * @Version: 1.0
 * @Description:
 */
class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("where am I");
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);

        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
/**output:
 * FileNotFoundException: java.io.FileNotFoundException
 * IOException: java.io.IOException
 * Throwable: java.lang.RuntimeException: where am I
 * SomeOtherException: com.thinkinginjava.error_handling_with_exceptions.example.chapter12_12.ex12_12_4.SomeOtherException
 */