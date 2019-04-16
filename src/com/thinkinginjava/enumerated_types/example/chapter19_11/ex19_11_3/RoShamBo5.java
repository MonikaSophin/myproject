package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_3;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.Competitor;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.RoShamBo;
import java.util.EnumMap;

import static com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome.*;


/**
 * @Author: monika
 * @Date: 2019/4/16 22:54
 * @Version: 1.0
 * @Description:
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;
    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, OutCome>> table =
            new EnumMap<>(RoShamBo5.class);
    static {
        for (RoShamBo5 it : RoShamBo5.values()) {
            table.put(it, new EnumMap<>(RoShamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }
    static void initRow(RoShamBo5 it, OutCome result1, OutCome result2, OutCome result3) {
        EnumMap<RoShamBo5, OutCome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, result1);
        row.put(RoShamBo5.SCISSORS, result2);
        row.put(RoShamBo5.ROCK, result3);
    }
    @Override
    public OutCome compete(RoShamBo5 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
/**output：
 * ROCK vs. ROCK : DRAW
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 * PAPER vs. SCISSORS : LOSE
 * PAPER vs. PAPER : DRAW
 * PAPER vs. SCISSORS : LOSE
 * ROCK vs. SCISSORS : WIN
 * SCISSORS vs. SCISSORS : DRAW
 * ROCK vs. SCISSORS : WIN
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 * ROCK vs. PAPER : LOSE
 * ROCK vs. SCISSORS : WIN
 * SCISSORS vs. ROCK : LOSE
 * PAPER vs. SCISSORS : LOSE
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 */