package com.thinkinginjava.io.example.chapter18_14;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @Author: monika
 * @Date: 2019/3/24 23:38
 * @Version: 1.0
 * @Description:
 */
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(
                PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            System.out.println(String.format(
                    "%s : %s", key, prefs.get(key, null)));
        }
        System.out.println("How many companious does Dorothy have? "
                + prefs.getInt("Companions", 0));
    }
}
/**output:
 * Location : Oz
 * Footwear : Ruby Slippers
 * Companions : 4
 * Are there witches? : true
 * UsageCount : 3 (该值存储在类似于注册表的键值对中，会随程序的运行次数而自增+1)
 * How many companious does Dorothy have? 4
 */