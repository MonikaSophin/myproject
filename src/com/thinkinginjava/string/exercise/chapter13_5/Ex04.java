package com.thinkinginjava.string.exercise.chapter13_5;

import java.util.Formatter;

/**
 * @Author: monika
 * @Date: 2019/1/1 14:12
 * @Version: 1.0
 * @Description: page 292
 * 练习04：修改Receipt.java,令所有的宽度都由一个常量来控制。目的是使宽度的改变更
 * 容易，只需修改一处的值即可。
 */
class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int w1;
    private int w2;
    private int w3;
    private String s1;
    private String s2;
    private String s3;

    public Receipt(int w1, int w2, int w3) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        s1 = "%-" + w1 + "s %" + w2 + "s %" + w3 + "s\n";
        s2 = "%-" + w1 + ".15s %" + w2 + "d %" + w3 + ".2f\n";
        s3 = "%-" + w1 + "s %" + w2 + "s %" + w3 + ".2f\n";
    }

    public void printTitle(){
        f.format(s1, "Item", "Qty", "Price");
        f.format(s1, "----", "---", "-----");
    }
    public void print(String name, int qty, double price){
        f.format(s2, name, qty, price);
        total += price;
    }
    public void printTotal(){
        f.format(s3, "Tax", "", total*0.06);
        f.format(s1, "", "", "-----");
        f.format(s3, "Total", "", total*1.06);
    }

}

public class Ex04 {
    public static void main(String[] args) {
        Receipt receipt = new Receipt(15,5,10);
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
/**output:
 * Item              Qty      Price
 * ----              ---      -----
 * Jack's Magic Be     4       4.25
 * Princess peas       3       5.10
 * Three Bears Por     1      14.29
 * Tax                         1.42
 *                            -----
 * Total                      25.06
 */