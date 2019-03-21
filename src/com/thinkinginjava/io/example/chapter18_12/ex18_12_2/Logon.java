package com.thinkinginjava.io.example.chapter18_12.ex18_12_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/20
 * @description:
 */
public class Logon implements Serializable {
    private Date data = new Date();
    private String username;
    private transient String password;
    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return String.format("Logon info: \n username: %s \n date: %s \n password: %s",
               username, data, password);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        String filePath = "src\\com\\thinkinginjava\\io\\example\\chapter18_12\\file\\Logon.out";
        Logon a = new Logon("Hulk", "MyLittlePony");
        System.out.println("Login a = " + a);

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(filePath));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filePath));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        System.out.println("Logon a = " + a);
    }
}
/**output:
 * Login a = Logon info:
 *  username: Hulk
 *  date: Wed Mar 20 17:20:47 CST 2019
 *  password: MyLittlePony
 * Recovering object at Wed Mar 20 17:20:49 CST 2019
 * Logon a = Logon info:
 *  username: Hulk
 *  date: Wed Mar 20 17:20:47 CST 2019
 *  password: null
 */