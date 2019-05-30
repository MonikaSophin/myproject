package com.thinkinginjava.concurrency.example.chapter21_9.ex21_9_2;

import com.thinkinginjava.util.CountingIntegerList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @author: XueYing.Cao
 * @date: 2019/5/30
 * @description:
 */
abstract class ListTest extends Tester<List<Integer>> {
    public ListTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }
    class Reader extends TestTask {
        long result = 0;
        @Override
        void test() {
            for (int i = 0; i < testCycles; i++)
                for (int index = 0; index < containerSize; index++)
                    result += testContainer.get(index);
        }
        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }
    class Writer extends TestTask {
        @Override
        void test() {
            for (int i = 0; i < testCycles; i++)
                for (int index = 0; index < containerSize; index++)
                    testContainer.set(index, writeData[index]);
        }
        @Override
        void putResults() {
            writeTime += duration;
        }
    }
    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++)
            exec.execute(new Reader());
        for (int i = 0; i < nWriters; i++)
            exec.execute(new Writer());
    }
}

class SynchronizedArrayListTest extends ListTest {
    public SynchronizedArrayListTest(int nReaders, int nWriters) {
        super("SynchronizeArrayList", nReaders, nWriters);
    }
    @Override
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(
                new ArrayList<>(new CountingIntegerList(containerSize)));
    }
}

class CopyOnWriteArrayListTest extends ListTest {
    public CopyOnWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }
    @Override
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<>(
                new CountingIntegerList(containerSize));
    }
}

public class ListComparisons {
    public static void main(String[] args) {
        Tester.initMain(1, 10, 10);
        new SynchronizedArrayListTest(10, 0);
        new SynchronizedArrayListTest(9, 1);
        new SynchronizedArrayListTest(5, 5);
        new CopyOnWriteArrayListTest(10, 0);
        new CopyOnWriteArrayListTest(9, 1);
        new CopyOnWriteArrayListTest(5, 5);
        Tester.exec.shutdown();
    }
}
/**output(Sample):
 * Type                             Read time     Write time
 * SynchronizeArrayList 10r 0w         165461              0
 * SynchronizeArrayList 9r 1w           77132          27681
 * readTime + writeTime =              104813
 * SynchronizeArrayList 5r 5w          142757         167949
 * readTime + writeTime =              310706
 * CopyOnWriteArrayList 10r 0w         171991              0
 * CopyOnWriteArrayList 9r 1w           75264          99526
 * readTime + writeTime =              174790
 * CopyOnWriteArrayList 5r 5w           37633         804292
 * readTime + writeTime =              841925
 */