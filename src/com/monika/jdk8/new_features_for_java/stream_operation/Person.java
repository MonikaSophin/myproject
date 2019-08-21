package com.monika.jdk8.new_features_for_java.stream_operation;

import lombok.Data;

/**
 * @author XueYing.Cao
 * @date 2019/8/19
 */
@Data
public class Person {
    private String name;
    private int age;
    private long number;
    private double income;

    public static class Builder {
        private String name;
        private int age;
        private long number;
        private double income;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder number(long number) {
            this.number = number;
            return this;
        }

        public Builder income(double income) {
            this.income = income;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.name = this.name;
            person.age = this.age;
            person.number = this.number;
            person.income = this.income;
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", income=" + income +
                ']';
    }
}
