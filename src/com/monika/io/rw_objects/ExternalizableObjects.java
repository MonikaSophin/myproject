package com.monika.io.rw_objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author XueYing.Cao
 * @date 2019/9/6
 */
public class ExternalizableObjects {

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
            Test one = new Test(1, "transient one", "one");
            oos.writeObject(one);

            Test test1 = (Test) ois.readObject();
            System.out.println("对象 " + test1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现Externalizable接口
     * 反序列化过程：
     * 1. 调用缺省的构造函数（一定要是public的，其他访问权限修饰符都会报错）
     * 2. 调用readExternal()，读取 经过writeExternal()序列化 的内容
     */
    @Data
    @AllArgsConstructor
    @ToString
    public static class Test implements Externalizable {

        private int i;
        private transient String ts;
        private String s;

        // 在反序列时，需要默认的构造函数
        public Test() {}

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
            out.writeObject(ts);
            //注意，变量s并没有序列化
            out.flush();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
            ts = (String) in.readObject();
        }

    }
}
/**output:
 * 对象 ExternalizableObjects.Test(i=1, ts=transient one, s=null)
 */