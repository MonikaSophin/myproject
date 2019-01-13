package com.thinkinginjava.string.example.chapter13_2;

/**
 * @Author: monika
 * @Date: 2018/12/31 14:46
 * @Version: 1.0
 * @Description:
 */
public class WhitherStringBuilder {
    public String imlicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++)
            result += fields[i];
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
    }
}
