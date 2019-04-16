package com.thinkinginjava.enumerated_types.example.chapter19_10;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
        @Override
        void f() { print("Overridden method"); }
    };
    void f() { print("default behavior"); }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }
}
/**output:
 * NUT: default behavior
 * BOLT: default behavior
 * WASHER: Overridden method
 */