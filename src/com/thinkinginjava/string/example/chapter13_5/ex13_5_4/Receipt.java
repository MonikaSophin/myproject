package com.thinkinginjava.string.example.chapter13_5.ex13_5_4;

import java.util.Formatter;

/**
 * @Author: monika
 * @Date: 2019/1/1 14:01
 * @Version: 1.0
 * @Description:
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle(){
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price){
        f.format("%-15.15s %5s %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal(){
        f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
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