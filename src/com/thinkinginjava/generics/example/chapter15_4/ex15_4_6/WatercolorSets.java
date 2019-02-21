package com.thinkinginjava.generics.example.chapter15_4.ex15_4_6;

import com.thinkinginjava.util.Sets;
import java.util.EnumSet;
import java.util.Set;
import static com.thinkinginjava.generics.example.chapter15_4.ex15_4_6.Watercolors.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/11
 * @description:
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

        // 并集
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));

        // 交集
        Set<Watercolors> subset = Sets.intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);

        // 超集减去子集
        System.out.println("difference(set1, set2): " + Sets.difference(set1, subset));

        // a,b并集减去a,b交集
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
/**output:
 * set1: [BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
 * set2: [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
 * union(set1, set2): [BURNT_SIENNA, BRILLIANT_RED, YELLOW_OCHRE, MAGENTA, SAP_GREEN, CERULEAN_BLUE_HUE, ULTRAMARINE, VIRIDIAN_HUE, VIOLET, RAW_UMBER, ROSE_MADDER, PERMANENT_GREEN, BURNT_UMBER, PHTHALO_BLUE, CRIMSON, COBALT_BLUE_HUE]
 * intersection(set1, set2): [PERMANENT_GREEN, CERULEAN_BLUE_HUE, ULTRAMARINE, VIRIDIAN_HUE, PHTHALO_BLUE, COBALT_BLUE_HUE]
 * difference(set1, set2): [BRILLIANT_RED, MAGENTA, VIOLET, CRIMSON, ROSE_MADDER]
 * complement(set1, set2): [BURNT_SIENNA, BRILLIANT_RED, YELLOW_OCHRE, MAGENTA, SAP_GREEN, VIOLET, RAW_UMBER, ROSE_MADDER, BURNT_UMBER, CRIMSON]
 */