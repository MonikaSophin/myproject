package com.thinkinginjava.enumerated_types.exercise.chapter19_7;

import com.thinkinginjava.controlling_execution.example.chapter4_8.VowelsAndConsonants;
import com.thinkinginjava.util.Print;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description: page 600
 * 练习05 : 修改{@link VowelsAndConsonants},使用3个enum类型：VOWEL、 SOMETIMES_A_VOWEL以及CONSONANT.
 * 其中的enum构造器应该可以接受属于不同类别的各种字母。提示：使用可变参数。要记住,可变参数会自动为你创建
 * 一个数组。
 */
enum VowelsAndConsonants5 {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('y', 'w'),
    CONSONANT('b','c','d','f','g','h','j','k','l','m',
            'n','p','q','r','s','t','v','x','z');
    private Character[] values;
    VowelsAndConsonants5(Character ... values) {
        this.values = values;
    }

    public Character[] getValues() { return values; }
    public void setValues(Character[] values) { this.values = values; }

    public static String printType(Character char1) {
        if (Arrays.asList(VOWEL.getValues()).contains(char1)) {
            return "vowel";
        }
        if (Arrays.asList(SOMETIMES_A_VOWEL.getValues()).contains(char1)) {
            return "sometimes a vowel";
        }
        if (Arrays.asList(CONSONANT.getValues()).contains(char1)) {
            return "consonant";
        }
        return CONSONANT.name();
    }
}

public class Ex05 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';//97~122
            Print.printnb((char) c + ", " + c + ": ");
            System.out.println(VowelsAndConsonants5.printType((char) c));
        }
    }
}
/**output:
 * y, 121: sometimes a vowel
 * n, 110: consonant
 * z, 122: consonant
 * b, 98: consonant
 * r, 114: consonant
 * n, 110: consonant
 * y, 121: sometimes a vowel
 * g, 103: consonant
 * c, 99: consonant
 * f, 102: consonant
 * o, 111: vowel
 * w, 119: sometimes a vowel
 * z, 122: consonant
 * n, 110: consonant
 * t, 116: consonant
 * c, 99: consonant
 * q, 113: consonant
 * r, 114: consonant
 * g, 103: consonant
 * s, 115: consonant
 * e, 101: vowel
 * g, 103: consonant
 * z, 122: consonant
 * m, 109: consonant
 * m, 109: consonant
 * j, 106: consonant
 * m, 109: consonant
 * r, 114: consonant
 * o, 111: vowel
 * e, 101: vowel
 * s, 115: consonant
 * u, 117: vowel
 * e, 101: vowel
 * c, 99: consonant
 * u, 117: vowel
 * o, 111: vowel
 * n, 110: consonant
 * e, 101: vowel
 * o, 111: vowel
 * e, 101: vowel
 * d, 100: consonant
 * l, 108: consonant
 * s, 115: consonant
 * m, 109: consonant
 * w, 119: sometimes a vowel
 * h, 104: consonant
 * l, 108: consonant
 * g, 103: consonant
 * e, 101: vowel
 * a, 97: vowel
 * h, 104: consonant
 * k, 107: consonant
 * c, 99: consonant
 * x, 120: consonant
 * r, 114: consonant
 * e, 101: vowel
 * q, 113: consonant
 * u, 117: vowel
 * c, 99: consonant
 * b, 98: consonant
 * b, 98: consonant
 * k, 107: consonant
 * i, 105: vowel
 * n, 110: consonant
 * a, 97: vowel
 * m, 109: consonant
 * e, 101: vowel
 * s, 115: consonant
 * b, 98: consonant
 * t, 116: consonant
 * w, 119: sometimes a vowel
 * h, 104: consonant
 * k, 107: consonant
 * j, 106: consonant
 * u, 117: vowel
 * r, 114: consonant
 * u, 117: vowel
 * k, 107: consonant
 * z, 122: consonant
 * p, 112: consonant
 * g, 103: consonant
 * w, 119: sometimes a vowel
 * s, 115: consonant
 * q, 113: consonant
 * p, 112: consonant
 * z, 122: consonant
 * d, 100: consonant
 * y, 121: sometimes a vowel
 * c, 99: consonant
 * y, 121: sometimes a vowel
 * r, 114: consonant
 * f, 102: consonant
 * j, 106: consonant
 * q, 113: consonant
 * a, 97: vowel
 * h, 104: consonant
 * x, 120: consonant
 * x, 120: consonant
 * h, 104: consonant
 * v, 118: consonant
 */