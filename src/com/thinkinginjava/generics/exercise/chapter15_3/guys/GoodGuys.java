package com.thinkinginjava.generics.exercise.chapter15_3.guys;

/**
 * @Author: monika
 * @Date: 2019/2/1 22:52
 * @Version: 1.0
 * @Description:
 */
public class GoodGuys extends StoryCharacters {
    @Override
    public String toString(){
        return String.format("GoodGuy[%s] %s", getClass().getSimpleName(), id);
    }
}
