package com.thinkinginjava.enumerated_types.example.chapter19_9;

import java.util.EnumMap;
import java.util.Map;

import com.thinkinginjava.enumerated_types.example.chapter19_8.AlarmPoints;
import static com.thinkinginjava.enumerated_types.example.chapter19_8.AlarmPoints.*;
import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/4/13 22:25
 * @Version: 1.0
 * @Description:
 */
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> print("kitchen fire!") );
        em.put(BATHROOM, () -> print("Bathroom alert!") );

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }

        try { // 如果特定键没有对应的值
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}
/**output:
 * BATHROOM: Bathroom alert!
 * KITCHEN: kitchen fire!
 * java.lang.NullPointerException
 */