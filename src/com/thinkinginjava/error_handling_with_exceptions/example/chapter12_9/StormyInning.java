package com.thinkinginjava.error_handling_with_exceptions.example.chapter12_9;

/**
 * @Author: monika
 * @Date: 2018/12/30 1:57
 * @Version: 1.0
 * @Description:
 */
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    // 确定为构造函数添加新的异常，但是必须处理基础构造函数异常：
    public StormyInning() throws RainedOut, BaseballException {}
    public StormyInning(String s) throws Foul, BaseballException {}

    // 常规方法必须符合基类：
//! public void walk() throws PopFoul {} //Compile error

    //接口不能从基类的现有方法添加异常：
//! public void event() throws RainedOut {}

    //如果基类中尚不存在该方法，则异常为OK
    public void rainHard() throws RainedOut {}

    //您可以选择不抛出任何异常，即使基本版本执行：
    public void event() {}

    // 重写的方法可以抛出继承的异常：
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // 在派生版本中没有抛出Strike。
        try {
            // 如果你向上转型怎么办？
            Inning i = new StormyInning();
            i.atBat();
            // 您必须从方法的基类版本中捕获异常：
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}