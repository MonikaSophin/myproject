package com.thinkinginjava.Initialize_clean.example.chapter5_6;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/11 15:17
 * @Version: 1.0
 * @Description:  基本类型数据成员都会有一个初始值(参见page 26),
 *                 char值为0，所以显示为空白。
 *                 在类中定义一个对象引用时，如果不将其初始化，此引用就会获得一个特殊值null。
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    void printInitialValues() {
        Print.print("Data type      Initial value");
        Print.print("boolean        " + t);
        Print.print("char           [" + c + "]");
        Print.print("byte           " + b);
        Print.print("short          " + s);
        Print.print("int            " + i);
        Print.print("long           " + l);
        Print.print("float          " + f);
        Print.print("double         " + d);
        Print.print("reference      " + reference);
    }

    public static void main(String[] args) {
        new InitialValues().printInitialValues();
    }
}
/**输出：
 * Data type      Initial value
 * boolean        false
 * char           [ ]
 * byte           0
 * short          0
 * int            0
 * long           0
 * float          0.0
 * double         0.0
 * reference      null
 */
