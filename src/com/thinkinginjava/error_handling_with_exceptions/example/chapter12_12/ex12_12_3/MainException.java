package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_12.ex12_12_3;

import java.io.FileInputStream;

/**
 * @Author: monika
 * @Date: 2018/12/30 19:39
 * @Version: 1.0
 * @Description:
 */
public class MainException {
    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream("MainException.java");
        file.close();
    }
}
/**output:
 * Exception in thread "main" java.io.FileNotFoundException: MainException.java (系统找不到指定的文件。)
 * 	at java.io.FileInputStream.open0(Native Method)
 * 	at java.io.FileInputStream.open(FileInputStream.java:195)
 * 	at java.io.FileInputStream.<init>(FileInputStream.java:138)
 * 	at java.io.FileInputStream.<init>(FileInputStream.java:93)
 * 	at com.thinkinginjava.error_handling_with_exceptions.example.chapter12_12.ex12_12_3.MainException.main(MainException.java:13)
 */