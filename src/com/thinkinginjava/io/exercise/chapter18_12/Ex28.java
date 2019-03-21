package com.thinkinginjava.io.exercise.chapter18_12;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/20
 * @description: page 578
 * 练习28：复制{@link Blips}并重命名为BlipCheck.java,然后将类Blip2重命名为BlipCheck
 * （使其成为public的，并在此过程中删除类Blips中的公共作用域）。删除文件中的//!标记，
 * 然后执行含有这几个错误行的程序。接下来，注释掉BlipCheck的默认构造器。执行并解释它可以
 * 运行的原因。注意编译后我们必须适应java Blips执行程序，因为main()方法仍在类Blips中。
 */
class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }
    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src\\com\\thinkinginjava\\io\\exercise\\chapter18_12\\file\\Ex28.out";
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck bc = new BlipCheck();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(filePath));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(bc);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath));
        print("Recovering b1:");
        b1 = (Blip1)in.readObject();
        print("Recovering bc:");
        bc = (BlipCheck)in.readObject();
    }
}
public class Ex28 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blips.main(args);
    }
}
