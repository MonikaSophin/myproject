package com.thinkinginjava.polymorphism.example.chapter8_5.ex8_5_2;

/**
 * @Author: monika
 * @Date: 2018/11/22 21:59
 * @Version: 1.0
 * @Description:   在java语言中，所有转型都会得到检查！所以即使我们只是进行一次普通的加括弧形式的
 *               类型转换，在进入运行期仍然会对其进行检查，以便保证它的确时我们希望的那种类型。如果
 *               不是，就会返回一个ClassCastException（类转型异常）。这种在运行期间对类型进行检查的
 *               行为被称作“运行时类型识别（RTTI）”。
 */
class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
    public void w() {}
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        // Compile time: method not found in Useful:
        //! x[1].u();
        ((MoreUseful)x[1]).u(); // Downcast/RTTI
        ((MoreUseful)x[0]).u(); // Exception thrown
    }
}
