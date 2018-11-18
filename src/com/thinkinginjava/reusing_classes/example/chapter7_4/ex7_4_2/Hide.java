package com.thinkinginjava.reusing_classes.example.chapter7_4.ex7_4_2;

/**
 * @Author: monika
 * @Date: 2018/11/17 18:26
 * @Version: 1.0
 * @Description:
 */
class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
/** 输出:
doh(float)
doh(char)
doh(float)
doh(Milhouse)
*/
