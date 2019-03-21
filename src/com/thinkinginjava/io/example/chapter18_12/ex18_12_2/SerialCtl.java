package com.thinkinginjava.io.example.chapter18_12.ex18_12_2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/20
 * @description:
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String a, String b) {
        this.a = "Not Transient: " +  a;
        this.b = "Transient: " + b;
    }
    @Override
    public String toString() { return a + "\n" + b; }

    /**
     * 注意： 是private修饰的， 所以不是覆盖Serializable的方法。
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        /**
         * {@link ObjectOutputStream#defaultWriteObject()}
         * 非transient字段由此方法保存。
         */
         stream.defaultWriteObject();
         stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);

        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }
}
