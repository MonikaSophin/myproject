package com.thinkinginjava.generics.exercise.chapter15_11;

/**
 * @Author: monika
 * @Date: 2019/2/15 22:06
 * @Version: 1.0
 * @Description: page 402
 * 练习31：从MultipleInterfaceVariants.java中移除所有泛型，并修改代码，
 * 使这个实例可以编译。
 */
interface Payable { float getPay(); }

class Employee implements Payable {
    private float weeklyPay;
    public float getPay() {
        return weeklyPay;
    }
}

class Hourly extends Employee {
    public String name;
    protected float hourlyPay;
    public int hoursWorked;
    Hourly(String s, float pay, int hours) {
        name = s;
        hourlyPay = pay;
        hoursWorked = hours;
    }
    public float getPay() {
        System.out.println("Pay " + name +
                " $" + hourlyPay * hoursWorked);
        return hourlyPay * hoursWorked;
    }
}
public class Ex31 {
    public static void main(String[] args) {
        Hourly h = new Hourly("Joe", 50.00f, 40);
        h.getPay();
    }
}
/**output:
 * Pay Joe $2000.0
 */