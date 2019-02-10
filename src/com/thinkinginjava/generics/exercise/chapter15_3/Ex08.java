package com.thinkinginjava.generics.exercise.chapter15_3;

import com.thinkinginjava.generics.exercise.chapter15_3.guys.*;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2019/2/1 22:46
 * @Version: 1.0
 * @Description: page 361
 * 练习08：模仿Coffee示例的样子，根据你喜欢的电影人物，创建一个StoryCharacters的
 * 类层次结构，将它们划分为GoodGuys和BadGuys。再按照CoffeeGenerator的形式，编写
 * 一个StoryCharacters的生成器。
 */
class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class[] types = { Luffy.class, Zoro.class,
            Namei.class, Mingo.class, Ainilu.class, };
    private static Random rand = new Random(47);
    public StoryCharactersGenerator() {}
    // For iteration:
    private int size = 0;
    public StoryCharactersGenerator(int sz) { size = sz; }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters)
                    types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    class StoryCharactersIterator implements Iterator<StoryCharacters> {
        int count = size;
        @Override
        public boolean hasNext() { return count > 0; }
        @Override
        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }
        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }
}

public class Ex08 {
    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for(StoryCharacters c : new StoryCharactersGenerator(5))
            System.out.println(c);
    }
}
/**output:
 * BadGuy[Mingo] 0
 * GoodGuy[Luffy] 1
 * BadGuy[Mingo] 2
 * GoodGuy[Zoro] 3
 * GoodGuy[Zoro] 4
 * BadGuy[Ainilu] 5
 * BadGuy[Mingo] 6
 * GoodGuy[Luffy] 7
 * GoodGuy[Namei] 8
 * GoodGuy[Namei] 9
 */