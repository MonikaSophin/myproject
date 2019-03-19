package com.thinkinginjava.io.example.chapter18_12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/18
 * @description:
 */
class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    @Override
    public String toString() { return Integer.toString(n); }
}

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;
    public Worm(int i, char c) {
        print("Worm constructor: " + i);
        this.next = next;
        this.c = c;
        if (--i > 0)
            next = new Worm(i, (char) (c + 1));
    }
    public Worm() {
        print("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d)
            result.append(data);
        result.append(")");
        if (next != null)
            result.append(next);
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\Data.out";
        Worm w = new Worm(6, 'a');
        print(" w = " + w);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
        String s2 = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        print(String.format("%s w2 = %s", s2, w2));

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.close();

        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        String s3 = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        print(String.format("%s w3 = %s", s3, w3));
    }
}
/**output:
 * Worm constructor: 6
 * Worm constructor: 5
 * Worm constructor: 4
 * Worm constructor: 3
 * Worm constructor: 2
 * Worm constructor: 1
 *  w = :a(853):b(119):c(802):d(788):e(199):f(881)
 * Worm storage
 *  w2 = :a(853):b(119):c(802):d(788):e(199):f(881)
 * Worm storage
 *  w3 = :a(853):b(119):c(802):d(788):e(199):f(881)
 */