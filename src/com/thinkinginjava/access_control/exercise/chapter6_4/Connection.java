package com.thinkinginjava.access_control.exercise.chapter6_4;

/**
 * @Author: monika
 * @Date: 2018/11/13 22:16
 * @Version: 1.0
 * @Description:
 */
public class Connection {
    private Connection() { System.out.println("Connection()");}
    // Allow creation via static method:
    static Connection makeConnection() {
        return new Connection();
    }
}
