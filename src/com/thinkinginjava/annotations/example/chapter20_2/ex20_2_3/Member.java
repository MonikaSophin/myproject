package com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3;

import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.Constraints;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.DBTable;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.SQLInteger;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.SQLString;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getHandle() { return handle; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    @Override
    public String toString() { return handle; }
    public Integer getAge() { return age; }
}
