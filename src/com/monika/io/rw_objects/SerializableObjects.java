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
 * 类作用：读写对象
 * 序列化流：ObjectInputStream
 * 反序列化流：ObjectOutputStream
 * <p>
 * Java实现序列化概念是为了提供对两种主要特性的支持：
 * 1. 远程方法调用
 * 2. Java Beans 状态的保存与恢复
 * <p>
 * 序列化注意的点：
 * 序列化对象需要让该对象内的所有对象都实现序列化接口，若该对象内的某些对象既没有被transient关键字标识，
 * 也没有实现序列化接口，那么在序列化时，会报NotSerializableException。
 * 反序列化注意的点：
 * 对象的默认反序列化机制将每个字段的内容恢复为写入时的值和类型。 声明为static或transient的字段被反序列化过程忽略。
 * 该序列化对象的所对应的class需要在反序列化环境的classpath中找得到，不然会报ClassNotFoundException。
 * <p>
 * 实现序列化的方式：
 * 1. 实现Serializable接口
 * -采用默认的序列化机制
 * 2. 实现Externalizable接口
 * -可以完全控制对象的输出内容
 * 3. 在实现了Serializable接口的序列化对象中添加private readObject() 和 private writeObject()
 * -作用与Externalizable接口类似
 */
public class SerializableObjects {

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
            System.out.println("静态字段 " + test1.getSs());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现Serializable接口
     */
    @Data
    @AllArgsConstructor
    @ToString
    public static class Test implements Serializable {
        private int i;
        private String s;
        private static String ss = "static field";
        private transient String ts;

        public static String getSs() {
            return ss;
        }
    }
}
/**output:
 * 对象 SerializableObjects.Test(i=1, s=one, ts=null)
 * 静态字段 static field
 */