package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1;

import com.thinkinginjava.enumerated_types.example.chapter19_11.OutCome;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
