package com.design_mode.structural_patterns.composite_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 1.
 * 创建 Employee 类，该类带有 Employee 对象的列表。
 */
public class Employee {
    //姓名
    private String name;
    //部门/职位
    private String dept;
    //薪水
    private int salary;
    //下属/下级
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]";
    }
}
