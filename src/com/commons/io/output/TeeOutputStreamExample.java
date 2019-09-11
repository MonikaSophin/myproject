package com.commons.io.output;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author XueYing.Cao
 * @date 2019/9/10
 */
public class TeeOutputStreamExample {

    public static void main(String[] args) {

        String input = "a b c d";
        //关闭ByteArrayOutputStream、ByteArrayInputStream是没有任何效果的（close方法是空方法体）。
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();

        try (TeeOutputStream tee = new TeeOutputStream(baos1, baos2)) {
            IOUtils.copy(bais, tee);
            System.out.println(baos1.toString());
            System.out.println(baos2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/**output:
 * a b c d
 * a b c d
 */