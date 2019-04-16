package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_2;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.Competitor;
import com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1.RoShamBo;

/**
 * @Author: monika
 * @Date: 2019/4/16 22:47
 * @Version: 1.0
 * @Description:
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        @Override
        public OutCome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };

    public OutCome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? OutCome.DRAW :
                ((opponent == loser) ? OutCome.WIN : OutCome.LOSE));
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
/**output:
 * PAPER vs. PAPER : DRAW
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 * SCISSORS vs. PAPER : WIN
 * ROCK vs. SCISSORS : WIN
 * ROCK vs. ROCK : DRAW
 * ROCK vs. SCISSORS : WIN
 * PAPER vs. SCISSORS : LOSE
 * SCISSORS vs. SCISSORS : DRAW
 * PAPER vs. SCISSORS : LOSE
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 * PAPER vs. ROCK : WIN
 * PAPER vs. SCISSORS : LOSE
 * SCISSORS vs. PAPER : WIN
 * ROCK vs. SCISSORS : WIN
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 * SCISSORS vs. ROCK : LOSE
 */