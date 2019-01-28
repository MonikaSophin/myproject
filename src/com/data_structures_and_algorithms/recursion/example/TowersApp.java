package com.data_structures_and_algorithms.recursion.example;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/25
 * @description: 清单 6.4 汉诺(Hanoi)塔
 */
public class TowersApp {
    private static int nDisks = 3;
    private static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1)
            System.out.println(String.format("Disk %s from %s to %s", 1, from, to));
        else {
            doTowers(topN - 1, from, to, inter);// from --> inter
            System.out.println(String.format("Disk %s from %s to %s", topN, from, to));
            doTowers(topN - 1, inter, from, to);// inter --> to
        }
    }

    public static void main(String[] args) {
        doTowers(nDisks, 'A', 'B', 'C');
    }
}
/**output:
 * Disk 1 from A to C
 * Disk 2 from A to B
 * Disk 1 from C to B
 * Disk 3 from A to C
 * Disk 1 from B to A
 * Disk 2 from B to C
 * Disk 1 from A to C
 */