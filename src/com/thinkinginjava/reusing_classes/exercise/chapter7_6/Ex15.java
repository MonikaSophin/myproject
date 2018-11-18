package com.thinkinginjava.reusing_classes.exercise.chapter7_6;

import com.thinkinginjava.reusing_classes.exercise.chapter7_6.ex15.BasicDevice;

/**
 * @Author: monika
 * @Date: 2018/11/17 18:48
 * @Version: 1.0
 * @Description: page 138
 * 练习15：在包中编写一个类，类应具备一个protected方法。在包外部，试着调用该
 * protected方法并解释其结果。然后，从你的类中继承产生一个类，并从该导出类的
 * 方法内部调用该protected方法。
 */
class DeviceFail {
    public static void main(String[] s) {
        BasicDevice fail = new BasicDevice();
        fail.showS();
        // fail.changeS("good-bye"); // cannot access protected method
    }
}

public class Ex15 extends BasicDevice {
    void changeBasic(String t) {
        super.changeS(t); // calls protected method
    }
    public static void main(String[] args) {
        Ex15 d = new Ex15();
        d.showS();
        d.changeBasic("Changed"); // derived class can access protected
        d.showS();
        DeviceFail.main(args);
    }
}
/**输出：
 * Ex15 Original
 * Ex15 Changed
 * BasicDevice Original
 */
