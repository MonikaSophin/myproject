package com.thinkinginjava.enumerated_types.example.chapter19_4;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
enum Search {
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;// up cast
        //! e.values(); // 父类Enum中没有values()方法
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
/**output:
 * HITHER
 * YON
 */

