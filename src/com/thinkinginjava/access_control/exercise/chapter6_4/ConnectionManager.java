package com.thinkinginjava.access_control.exercise.chapter6_4;

/**
 * @Author: monika
 * @Date: 2018/11/13 22:16
 * @Version: 1.0
 * @Description:
 */
public class ConnectionManager {
    static int howManyLeft = 3;
    static Connection[] ca = new Connection[howManyLeft];
    static {
        for (int i = 0; i < ca.length; i++) {
            Connection.makeConnection();
        }
    }
    public static Connection getConnection() {
        if (howManyLeft > 0)
            return ca[--howManyLeft];
        else {
            System.out.println("No more connections");
            return null;
        }
    }
}
