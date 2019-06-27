package com.design_mode.structural_patterns.composite_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        //CEO
        Employee CEO = new Employee("John", "CEO", 30000);

        //销售主管
        Employee headSales = new Employee("Robert", "Head Sales", 20000);

        //市场主管
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        //--销售主管下属
        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        //--市场主管下属
        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工 结构
        System.out.println(CEO);
        for (Employee e : CEO.getSubordinates()) {
            System.out.println(e);
            for (Employee ee : e.getSubordinates()) {
                System.out.println(ee);
            }
        }

    }
}
