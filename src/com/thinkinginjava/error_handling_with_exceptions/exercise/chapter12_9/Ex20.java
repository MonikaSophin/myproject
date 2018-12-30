package com.thinkinginjava.error_handling_with_exceptions.exercise.chapter12_9;

/**
 * @Author: monika
 * @Date: 2018/12/30 2:25
 * @Version: 1.0
 * @Description: page 271
 * 练习20：修改StormyInning.java，加一个UmpireArgument异常，和一个能抛出此异常的方法。
 * 测试一下修改后的异常继承体系。
 */
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
class UmpireArgument extends BaseballException {}
class ThrownFromGame extends UmpireArgument {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {
        // Doesn't actually have to throw anything
    }
    public abstract void atBat() throws Strike, Foul, UmpireArgument;
    public void questionableCall() throws UmpireArgument {}
    public void walk() {} // Throws no checked exceptions
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}


interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

class StormyInning20 extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you
    // must deal with the base constructor exceptions:
    public StormyInning20()
            throws UmpireArgument, RainedOut, BaseballException {}
    public StormyInning20(String s)
            throws Foul, BaseballException {}

    // Regular methods must comform to base class:
    //! void walk() throws PopFoul {} // Compile error
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    //! public void event() throws RainedOut {}
    // If method doesn't already exist in the
    // base class, the exception is OK:
    public void rainHard() throws RainedOut {}

    // You can choose to not throw any exceptions,
    // even if the base class version does:
    public void event() {}

    // 重写的方法可以抛出继承的异常
    public void atBat() throws PopFoul, ThrownFromGame {
        throw new ThrownFromGame();
    }
    public void questionableCall() throws UmpireArgument {
        throw new UmpireArgument();
    }
}

public class Ex20 {
    public static void main(String[] args) {
        try {
            StormyInning20 si = new StormyInning20();
            si.atBat();
            si.questionableCall();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(UmpireArgument e) {
            System.out.println("Umpire argument (StormyInning20)");
            // } catch(ThrownFromGame e) {
            //	System.out.println("Thrown from game");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning20();
            i.atBat();
            // You must catch the exceptions from
            // the base-class version of the method:
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(ThrownFromGame e) {
            System.out.println("Thrown from game (Inning)");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
/**output:
 * Umpire argument (StormyInning20)
 * Thrown from game (Inning)
 */