package com.thinkinginjava.string.exercise.chapter13_6;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:47
 * @Version: 1.0
 * @Description: page 297
 * 练习09：参考java.util.regex.Pattern的文档，用下划线替换Splitting.knights的所有元音字母。
 */
public class Ex09 {
    static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        /**
         * 若用多个字母组成的单词可以用'|'进行逻辑或，例如：
         * {@link com.thinkinginjava.string.example.chapter13_6.ex13_6_1.Replacing#main(String[])}
         */
        //String split1 = knights.replaceAll("a|e|i|o|u|A|E|I|O|U","_");
        // System.out.println(split1);

        String split2 = knights.replaceAll("[AEIOUaeiou]","_");
        System.out.println(split2);
    }
}
/**output:
 * Th_n, wh_n y__ h_v_ f__nd th_ shr_bb_ry, y__ m_st c_t d_wn th_ m_ght__st tr__ _n th_ f_r_st... w_th... _ h_rr_ng!
 */