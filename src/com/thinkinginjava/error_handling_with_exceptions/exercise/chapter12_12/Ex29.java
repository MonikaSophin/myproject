package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_12;

/**
 * @Author: monika
 * @Date: 2018/12/30 17:35
 * @Version: 1.0
 * @Description: page 281
 * 练习29：修改StormyInning.java中所有的异常类型，使它们扩展RuntimeException,并
 * 这是你这里不需要任何异常说明或try语句块。移除“//!”注释并展示这些方法不需要说明就可以
 * 编译。
 */
class BaseballException extends RuntimeException {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends RuntimeException {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

class StormyInning extends Inning implements Storm {
    public StormyInning() {}
    public StormyInning(String s) {}

    public void walk() {}
    public void rainHard() {}
    public void event() {}
    public void atBat() {}
}

public class Ex29 {
    public static void main(String[] args) {
        StormyInning si = new StormyInning();
        si.atBat();

        Inning i = new StormyInning();
        i.atBat();
    }
}
//~
