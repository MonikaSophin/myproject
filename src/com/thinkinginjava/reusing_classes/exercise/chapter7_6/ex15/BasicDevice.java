package com.thinkinginjava.reusing_classes.exercise.chapter7_6.ex15;

/**
 * @Author: monika
 * @Date: 2018/11/17 18:52
 * @Version: 1.0
 * @Description:
 */
public class BasicDevice {
    private String s = "Original";
    public BasicDevice() { s = "Original"; }
    protected void changeS(String c) { // outside package, only derived
        s = c;            // classes can access protected method
    }
    public void showS() {
        System.out.println(this.getClass().getSimpleName()+" "+s);
    }
}
