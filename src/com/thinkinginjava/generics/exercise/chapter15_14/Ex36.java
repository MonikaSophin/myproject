package com.thinkinginjava.generics.exercise.chapter15_14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:52
 * @Version: 1.0
 * @Description: page 412
 * 练习36：在Processor类中添加第二个参数化异常，并演示这些异常可以相互独立变化。
 */
interface Processor<T, E extends Exception, F extends Exception> {
    void process(List<T> resultCollector) throws E, F;
}

class ProcessRunner<T, E extends Exception, F extends Exception>
        extends ArrayList<Processor<T, E, F>> {
    List<T> processAll() throws E, F{
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T,E,F> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}

class Failure1 extends Exception {}
class Failure2 extends Exception {}

class Processor1 implements Processor<String, Failure1, Failure2> {
    static int count = 3;
    public void
    process(List<String> resultCollector) throws Failure1, Failure2 {
        if(count-- > 1)
            resultCollector.add("Hep!");
        else
            throw new Failure2();
        if(count < 0)
            throw new Failure1();
    }
}

class Processor2 implements Processor<Integer, Failure1, Failure2> {
    static int count = 2;
    public void
    process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0)
            resultCollector.add(47);
        else
            resultCollector.add(11);
        if(count < 0)
            throw new Failure2();
    }
}
public class Ex36 {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1, Failure2> runner = new ProcessRunner<>();
        for(int i = 0; i < 3; i++)
            runner.add(new Processor1());
        try {
            System.out.println(runner.processAll());
        } catch(Failure1 e) {
            System.out.println("Processor1 throw Failure1");
        } catch (Failure2 e) {
            System.out.println("Processor1 throw Failure2");
        }

        ProcessRunner<Integer, Failure1, Failure2> runner2 = new ProcessRunner<>();
        for(int i = 0; i < 3; i++)
            runner2.add(new Processor2());
        try {
            System.out.println(runner2.processAll());
        } catch(Failure1 e) {
            System.out.println("Processor2 throw Failure1");
        } catch (Failure2 e) {
            System.out.println("Processor2 throw Failure2");
        }
    }
}
/**output:
 * Processor1 throw Failure2
 * Processor2 throw Failure2
 */