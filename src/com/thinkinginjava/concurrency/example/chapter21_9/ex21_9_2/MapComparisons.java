package com.thinkinginjava.concurrency.example.chapter21_9.ex21_9_2;

import com.thinkinginjava.util.CountingGenerator;
import com.thinkinginjava.util.MapData;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/30
 * @description:
 */
abstract class MapTest extends Tester<Map<Integer, Integer>> {
    public MapTest(String testId, int nReaders, int nWriters) {
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
                    testContainer.put(index, writeData[index]);
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

class SynchronizedHashMapTest extends MapTest {
    public SynchronizedHashMapTest(int nReaders, int nWriters) {
        super("SynchronizedHashMap", nReaders, nWriters);
    }
    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(new HashMap<>(
                MapData.map(
                        new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containerSize)));
    }
}

class ConcurrentHashMapTest extends MapTest {
    public ConcurrentHashMapTest(int nReaders, int nWriters) {
        super("ConcurrentHashMap", nReaders, nWriters);
    }
    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<>(MapData.map(
                new CountingGenerator.Integer(),
                new CountingGenerator.Integer(),
                containerSize));
    }
}

public class MapComparisons {
    public static void main(String[] args) {
        Tester.initMain(1, 10, 10);
        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);
        new ConcurrentHashMapTest(10, 0);
        new ConcurrentHashMapTest(9, 1);
        new ConcurrentHashMapTest(5, 5);
        Tester.exec.shutdown();
    }
}
/**output(Sample):
 * Type                             Read time     Write time
 * SynchronizedHashMap 10r 0w          297954              0
 * SynchronizedHashMap 9r 1w           180392          38255
 * readTime + writeTime =              218647
 * SynchronizedHashMap 5r 5w           127206         160796
 * readTime + writeTime =              288002
 * ConcurrentHashMap 10r 0w            228286              0
 * ConcurrentHashMap 9r 1w             146488          35767
 * readTime + writeTime =              182255
 * ConcurrentHashMap 5r 5w              65004          89885
 * readTime + writeTime =              154889
 */