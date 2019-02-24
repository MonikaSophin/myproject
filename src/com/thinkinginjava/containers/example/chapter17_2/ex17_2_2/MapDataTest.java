package com.thinkinginjava.containers.example.chapter17_2.ex17_2_2;

import com.thinkinginjava.util.*;
import java.util.Iterator;
import static com.thinkinginjava.util.Print.print;

/**
 * @Author: monika
 * @Date: 2019/2/24 17:54
 * @Version: 1.0
 * @Description:
 */
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return number < size; }
            @Override
            public Integer next() { return number++; }
            @Override
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        print(MapData.map(new Letters(), 11));
        print(MapData.map(new CountingGenerator.Character(),
                new RandomGenerator.String(3), 8));
        print(MapData.map(new CountingGenerator.Character(), "Value", 6));
        print(MapData.map(new Letters(), new RandomGenerator.String(3)));
        print(MapData.map(new Letters(), "Pop"));
    }
}
/**output:
 * {1=A, 2=B, 3=C, 4=D, 5=E, 6=F, 7=G, 8=H, 9=I, 10=J, 11=K}
 * {a=YNz, b=brn, c=yGc, d=FOW, e=ZnT, f=cQr, g=Gse, h=GZM}
 * {a=Value, b=Value, c=Value, d=Value, e=Value, f=Value}
 * {1=mJM, 2=RoE, 3=suE, 4=cUO, 5=neO, 6=EdL, 7=smw, 8=HLG}
 * {1=Pop, 2=Pop, 3=Pop, 4=Pop, 5=Pop, 6=Pop, 7=Pop, 8=Pop}
 */