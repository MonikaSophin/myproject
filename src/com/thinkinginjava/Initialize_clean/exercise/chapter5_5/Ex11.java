package com.thinkinginjava.Initialize_clean.exercise.chapter5_5;

/**
 * @Author: monika
 * @Date: 2018/11/11 12:52
 * @Version: 1.0
 * @Description: page 89
 * 练习11：修改前一个练习的程序，让你的finalize()总会被调用。
 */
class WebBank2 {
    boolean loggedIn = false;
    String name;
    WebBank2(String name, boolean logStatus) {
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

public class Ex11 {
    public static void main(String[] args) {
        WebBank2 bank1 = new WebBank2("bank1", true);
        WebBank2 bank2 = new WebBank2("bank2", true);
        new WebBank2("bank3", true);

        bank1.logOut();//将logStatus设为false

        System.out.println("Try 1: ");
        System.runFinalization();
        System.out.println("Try 2: ");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
        System.gc();
        System.out.println("Try 4: ");
        // using deprecated since 1.1 method:
        System.runFinalizersOnExit(true);//在gc()后，这个方法必会执行finalize();
    }
}
/**
 * 输出:
 * name :bank1
 * name :bank2
 * name :bank3
 * Try 1:
 * Try 2:
 * Try 3:
 * Try 4:
 * Error:logged_in -->bank3
 * finalize(); -->bank3
 * Error:logged_in -->bank2
 * finalize(); -->bank2
 * finalize(); -->bank1
 */