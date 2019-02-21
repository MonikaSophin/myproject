package com.thinkinginjava.arrays.exercise.chapter16_6;

import com.thinkinginjava.util.Generated;
import com.thinkinginjava.util.Generator;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 450
 * 练习17：创建并测试用于BigDecimal的Generator，并确保它可以用于Generated中的方法。
 */
class BigDecimalGenerator implements Generator<BigDecimal> {
    private BigDecimal value = new BigDecimal(0);
    private BigDecimal addValue = new BigDecimal(1000000000);
    @Override
    public BigDecimal next() {
        return value = value.add(addValue);
    }
}

public class Ex17 {
    public static void main(String[] args) {
        int size = 6;
        BigDecimal[] a1 = Generated.array(new BigDecimal[size], new BigDecimalGenerator());
        BigDecimal[] a2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), size);
        System.out.println(String.format("BigDecimal[] a1 = %s", Arrays.toString(a1)));
        System.out.println(String.format("BigDecimal[] a2 = %s", Arrays.toString(a2)));
    }
}
/**output:
 * BigDecimal[] a1 = [1000000000, 2000000000, 3000000000, 4000000000, 5000000000, 6000000000]
 * BigDecimal[] a2 = [1000000000, 2000000000, 3000000000, 4000000000, 5000000000, 6000000000]
 */