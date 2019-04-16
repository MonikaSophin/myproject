package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_4;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;
import static com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome.*;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.Competitor;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.RoShamBo;

/**
 * @Author: monika
 * @Date: 2019/4/16 23:12
 * @Version: 1.0
 * @Description:
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;
    private static OutCome[][] table = {
            { DRAW, LOSE, WIN },
            { WIN, DRAW, LOSE },
            { LOSE, WIN, DRAW },
    };
    @Override
    public OutCome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
/**output:
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