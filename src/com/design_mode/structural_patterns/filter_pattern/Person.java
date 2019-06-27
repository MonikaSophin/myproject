package com.design_mode.structural_patterns.filter_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 1.创建一个类，在该类上应用筛选标准。
 */
public class Person {
    //姓名
    private String name;
    //性别
    private String gender;
    //婚否
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
