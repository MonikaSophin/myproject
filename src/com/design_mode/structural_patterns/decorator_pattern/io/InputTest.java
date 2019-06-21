package com.design_mode.structural_patterns.decorator_pattern.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: monika
 * @Date: 2019/6/9 18:37
 * @Version: 1.0
 * @Description:
 */
public class InputTest {
    static String filename = "src\\com\\design_mode\\c_decorator_pattern\\io\\test";
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filename)));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * i know the decorator pattern therefore i rule!
 */