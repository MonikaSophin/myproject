package com.thinkinginjava.annotations.example.chapter20_2.ex20_2_5;

import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.Constraints;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.DBTable;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.SQLInteger;
import com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
public class TableCreator {
    static String[] classNames = {"com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.Member"};

    public static void main(String[] args) throws Exception {
        for (String className : classNames) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1)
                tableName = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1)
                    continue;
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(String.format("%s INT%s",
                            columnName, getConstraints(sInt.constraints())));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();
                    columnDefs.add(String.format("%s VARCHAR(%s)%s",
                            columnName, sString.value(), getConstraints(sString.constraints())));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs)
                    createCommand.append("\n    " + columnDef + ",");
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + "is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY Key";
        if (con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
/**output:
 * Table Creation SQL for com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.Memberis :
 * CREATE TABLE MEMBER(
 *     FIRSTNAME VARCHAR(30));
 * Table Creation SQL for com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.Memberis :
 * CREATE TABLE MEMBER(
 *     FIRSTNAME VARCHAR(30),
 *     LASTNAME VARCHAR(50));
 * Table Creation SQL for com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.Memberis :
 * CREATE TABLE MEMBER(
 *     FIRSTNAME VARCHAR(30),
 *     LASTNAME VARCHAR(50),
 *     AGE INT);
 * Table Creation SQL for com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.Memberis :
 * CREATE TABLE MEMBER(
 *     FIRSTNAME VARCHAR(30),
 *     LASTNAME VARCHAR(50),
 *     AGE INT,
 *     HANDLE VARCHAR(30) PRIMARY Key);
 */