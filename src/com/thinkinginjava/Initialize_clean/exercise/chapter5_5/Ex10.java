package com.thinkinginjava.Initialize_clean.exercise.chapter5_5;

/**
 * @Author: monika
 * @Date: 2018/11/11 12:51
 * @Version: 1.0
 * @Description: page 89
 * 练习10：编写具有finalize()方法的类。并在方法中打印消息。在main()中为该类创建一
 * 个对象。试解释这个程序的行为。
 */
class WebBank1 {
    boolean loggedIn = false;
    String name;
    WebBank1(String name, boolean logStatus) {
        this.name = name;
        loggedIn = logStatus;
        System.out.println("name :" + this.name);
    }
    void logOut() {
        loggedIn = false;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (loggedIn)
            System.out.println("Error:logged_in -->" + this.name);
        System.out.println("finalize(); -->" + this.name);
    }
}

public class Ex10 {
    public static void main(String[] args) {
        WebBank1 bank1 = new WebBank1("bank1", true);
        WebBank1 bank2 = new WebBank1("bank2", true);
        new WebBank1("bank3", true);//这个对象gc时finalize()会被调用

        bank1.logOut();

        System.gc();
    }
}
/**
 * 输出：
 * name :bank1
 * name :bank2
 * name :bank3
 * Error:logged_in -->bank3
 * finalize(); -->bank3
 */