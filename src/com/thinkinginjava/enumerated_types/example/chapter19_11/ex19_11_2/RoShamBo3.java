package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_2;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.Competitor;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.RoShamBo;

/**
 * @Author: monika
 * @Date: 2019/4/16 22:38
 * @Version: 1.0
 * @Description:
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        @Override
        public OutCome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return OutCome.DRAW;
                case SCISSORS: return OutCome.LOSE;
                case ROCK: return OutCome.WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public OutCome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return OutCome.WIN;
                case SCISSORS: return OutCome.DRAW;
                case ROCK: return OutCome.LOSE;
            }
        }
    },
    ROCK {
        @Override
        public OutCome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return OutCome.LOSE;
                case SCISSORS: return OutCome.WIN;
                case ROCK: return OutCome.DRAW;
            }
        }
    };
    public abstract OutCome compete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
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