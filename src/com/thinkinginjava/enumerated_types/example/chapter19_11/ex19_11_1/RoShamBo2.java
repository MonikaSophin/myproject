package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;
import static com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);
    private OutCome result1, result2, result3;
    RoShamBo2(OutCome result1, OutCome result2, OutCome result3) {
        this.result1 = result1;
        this.result2 = result2;
        this.result3 = result3;
    }

    @Override
    public OutCome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER: return result1;
            case SCISSORS: return result2;
            case ROCK: return result3;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
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