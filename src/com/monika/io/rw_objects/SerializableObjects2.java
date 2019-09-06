package com.monika.io.rw_objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author XueYing.Cao
 * @date 2019/9/6
 */
public class SerializableObjects2 {

    public static void main(String[] args) {
        String fileOutName = "D:/GithubRepository/myproject/src/com/monika/io/rw_objects/test_output";
        try (
                //序列化流
                FileOutputStream fos = new FileOutputStream(fileOutName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                //反序列化流
                FileInputStream fis = new FileInputStream(fileOutName);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Test one = new Test(1, "one", "transient one");
            oos.writeObject(one);

            Test test1 = (Test) ois.readObject();
            System.out.println("对象 " + test1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在实现了Serializable接口的序列化对象中添加（不是覆盖、不是重载、而是添加）
     *    private readObject(ObjectInputStream in)
     *    private writeObject(ObjectOutputStream out)
     * 访问修饰符一定要是private，不然起不到 控制对象内容序列化 的作用。
     * 该作用与Externalizable接口的作用类似。
     */
    @Data
    @AllArgsConstructor
    @ToString
    public static class Test implements Serializable {
        private int i;
        private String s;
        private transient String ts;

        public Test() {
            System.out.println("default constructor");
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            //在首行调用默认序列化函数
            out.defaultWriteObject();
            out.writeObject(ts);
            out.flush();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            //与writeObject()同步
            // 在writeObject()方法体中out.defaultWriteObject()在首行，in.readObject()也一定要在首行
            // 在writeObject()方法体中out.defaultWriteObject()在第二行，in.readObject()也一定要在第二行
            // 否则会报错：java.io.StreamCorruptedException 或 java.io.EOFException
            in.defaultReadObject();
            ts = (String) in.readObject();
        }
    }
}
/**output:
 * 对象 SerializableObjects2.Test(i=1, s=one, ts=transient one)
 */