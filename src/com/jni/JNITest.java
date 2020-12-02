package com.jni;

/**
 * @author Sakata Gintoki
 * @date 2020/6/22
 */
public class JNITest {
    //为确保程序启动时，已经加载到lib，使用static代码块
    static {
        //filename:是生成的动态链接库的地址
        System.load("/home/root/libJNITestImpl.so");
        //libname: 是生成的动态链接库的名称，需要设置LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/root
        //System.loadLibrary("libJNITestImpl");
    }

    //定义本地方法接口
    public native void test();

    public static void main(String[] args) {
        new JNITest().test();
    }
}
