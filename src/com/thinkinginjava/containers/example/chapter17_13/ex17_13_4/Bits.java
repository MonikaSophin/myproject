package com.thinkinginjava.containers.example.chapter17_13.ex17_13_4;

import java.util.BitSet;
import java.util.Random;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/4
 * @description:
 */
public class Bits {
    public static void printBitSet(BitSet bitSet) {
        print("bits = " + bitSet);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitSet.size(); i++) {
            sb.append(bitSet.get(i) ? "1" : "0");
        }
        print("bit pattern:" + sb);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        byte bt = (byte) rand.nextInt();
        BitSet bitSet1 = new BitSet();
        for (int i = 7; i >= 0; i--) {
            if ((1 << i & bt) != 0)
                bitSet1.set(i);
            else
                bitSet1.clear(i);
        }
        print("byte value: " + bt);
        printBitSet(bitSet1);
        print();

        short st = (short) rand.nextInt();
        BitSet bitSet2 = new BitSet();
        for (int i = 15; i >= 0; i--) {
            if ((1 << i & bt) != 0)
                bitSet2.set(i);
            else
                bitSet2.clear(i);
        }
        print("short value: " + st);
        printBitSet(bitSet2);
        print();

        int it = rand.nextInt();
        BitSet bitSet3 = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if ((1 << i & bt) != 0)
                bitSet3.set(i);
            else
                bitSet3.clear(i);
        }
        print("int value: " + it);
        printBitSet(bitSet3);
        print();

        BitSet b127 = new BitSet();
        b127.set(127);
        print("set bit 127: " + b127);
        BitSet b255 = new BitSet();
        b127.set(255);
        print("set bit 255: " + b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        b1023.set(1024);
        print("set bit 1023:" + b1023);
    }
}
/**output:
 * byte value: -107
 * bits = {0, 2, 4, 7}
 * bit pattern:1010100100000000000000000000000000000000000000000000000000000000
 *
 * short value: 1302
 * bits = {0, 2, 4, 7, 8, 9, 10, 11, 12, 13, 14, 15}
 * bit pattern:1010100111111111000000000000000000000000000000000000000000000000
 *
 * int value: -2014573909
 * bits = {0, 2, 4, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}
 * bit pattern:1010100111111111111111111111111100000000000000000000000000000000
 */