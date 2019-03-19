package com.thinkinginjava.io.exercise.chapter18_12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/19
 * @description: page 574
 * 练习27：创建一个Serializable类，它包含一个对第二个Serializable类的对象的引用。
 * 创建你的类的实例，将其序列化到硬盘上，然后恢复它，并验证这个过程可以正确地工作。
 */
public class Ex27 implements Serializable {
    private int i;
    public Ex27(int i) {
        this.i = i;
    }
    public Ex27() {
        print("Ex27 default constructor");
    }

    @Override
    public String toString() {
        return "Ex27 constructor: " + i;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_12\\file\\Ex27.out";
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath));
        oos.writeObject("write Ex27\n");
        oos.writeObject(new Ex27(8));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath));
        String s = (String) ois.readObject();
        Ex27 ex27 = (Ex27) ois.readObject();
        print(s + ex27);
    }
}
/**output:
 * write Ex27
 * Ex27 constructor: 8
 */