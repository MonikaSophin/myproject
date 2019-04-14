package com.thinkinginjava.enumerated_types.example.chapter19_8;

import java.util.EnumSet;
import static com.thinkinginjava.enumerated_types.example.chapter19_8.AlarmPoints.*;
import static com.thinkinginjava.util.Print.*;
/**
 * @Author: monika
 * @Date: 2019/4/13 22:03
 * @Version: 1.0
 * @Description:
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        print(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        /**
         * {@link EnumSet#complementOf(EnumSet)} :
         * 除去EnumSet的enum还剩下的enum值。
         */
        points = EnumSet.complementOf(points);
        print(points);

        EnumSet<AlarmPoints> all = EnumSet.allOf(AlarmPoints.class);
        EnumSet<AlarmPoints> complement = EnumSet.complementOf(all);
        print();
        print("EnumSet.allOf(AlarmPoints.class): " + all);
        print("EnumSet.complementOf(all): " + complement);
    }
}
/**output:
 * BATHROOM]
 * [STAIR1, STAIR2, BATHROOM, KITCHEN]
 * [LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
 * [LOBBY, BATHROOM, UTILITY]
 * [STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
 *
 * EnumSet.allOf(AlarmPoints.class): [STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN]
 * EnumSet.complementOf(all): []
 */