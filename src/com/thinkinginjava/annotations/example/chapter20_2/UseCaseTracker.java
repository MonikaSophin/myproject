package com.thinkinginjava.annotations.example.chapter20_2;

import com.thinkinginjava.annotations.example.chapter20_1.ex20_1_1.PasswordUtils;
import com.thinkinginjava.annotations.example.chapter20_1.ex20_1_1.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer i : useCases) {
            System.out.println("Warning Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
/**output:
 * Found Use Case:49 New password can't equal previously used ones
 * Found Use Case:47 Password must contain at least one numeric
 * Found Use Case:48 no description
 * Warning Missing use case-50
 */