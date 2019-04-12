package com.thinkinginjava.enumerated_types.example.chapter19_7;

import com.thinkinginjava.util.Enums;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    private Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }
    public Security randomSelection() {
        return Enums.random(values);
    }

    interface Security {
        enum Stock implements Security { SHORT, LONG, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
/**output:
 * BOND: MUNICIPAL
 * BOND: MUNICIPAL
 * STOCK: MARGIN
 * STOCK: MARGIN
 * BOND: JUNK
 * STOCK: SHORT
 * STOCK: LONG
 * STOCK: LONG
 * BOND: MUNICIPAL
 * BOND: JUNK
 */
