package com.concurrent;

import org.apache.commons.io.IOUtils;
import org.openjdk.jol.info.ClassLayout;
import java.io.IOException;

/**
 * @Author Sakata Gintoki
 * @Date 2020/5/10 11:18
 * @Version 1.0
 * @Description 测试对象的布局
 */
public class ObjectHeaderTest {

    static {
        Process exec = null;
        try {
            // 方法阻塞, 等待命令执行完成（成功会返回0）
            exec = Runtime.getRuntime().exec("java -version");
            exec.waitFor();
            System.out.println(IOUtils.toString(exec.getInputStream(), "utf-8"));
            System.out.println(IOUtils.toString(exec.getErrorStream(), "utf-8"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (exec != null) {
            exec.destroy();
        }
    }

    private static class Example {
    }

    public static void main(String[] args) {
        Example example = new Example();
        int hashCode = example.hashCode();
        System.out.println(Integer.toHexString(hashCode));
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
    }
}
