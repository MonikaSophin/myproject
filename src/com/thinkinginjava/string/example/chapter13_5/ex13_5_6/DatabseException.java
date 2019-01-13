package com.thinkinginjava.string.example.chapter13_5.ex13_5_6;

/**
 * @Author: monika
 * @Date: 2019/1/1 14:42
 * @Version: 1.0
 * @Description:
 */
public class DatabseException extends Exception {
    public DatabseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s",transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/**output:
 * com.thinkinginjava.string.example.chapter13_5.ex13_5_6.DatabseException: (t3, q7) Write failed
 */