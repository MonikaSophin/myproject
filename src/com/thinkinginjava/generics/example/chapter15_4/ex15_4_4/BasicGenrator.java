package com.thinkinginjava.generics.example.chapter15_4.ex15_4_4;

import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;

/**
 * @Author: monika
 * @Date: 2019/2/4 16:30
 * @Version: 1.0
 * @Description:
 */
public class BasicGenrator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenrator(Class<T> type) { this.type = type; }
    @Override
    public T next() {
        try{
            return type.newInstance();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenrator<>(type);
    }
}
