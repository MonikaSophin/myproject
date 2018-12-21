package com.data_structures_and_algorithms.array.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/17
 * @description: page 41
 * 清单2.5
 */
class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print("  Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }
}

class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int maxSize) {
        a = new Person[maxSize];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return null;
        else
            return a[j];
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            a[i].displayPerson();
        }
    }
}

public class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ClassDataArray arr;
        arr = new ClassDataArray(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Winh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.display();

        String searchKey = "Stimson";
        Person found = arr.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.displayPerson();
        } else
            System.out.println("Can't find " + searchKey);

        System.out.println("Deleting smith, Yee, Creswell");
        arr.delete("smith");
        arr.delete("Yee");
        arr.delete("Creswell");

        arr.display();
    }
}
/**
 * 输出;
 * Last name: Evans, First name: Patty, Age: 24
 * Last name: Smith, First name: Lorraine, Age: 37
 * Last name: Yee, First name: Tom, Age: 43
 * Last name: Adams, First name: Henry, Age: 63
 * Last name: Hashimoto, First name: Sato, Age: 21
 * Last name: Stimson, First name: Henry, Age: 29
 * Last name: Velasquez, First name: Jose, Age: 72
 * Last name: Lamarque, First name: Henry, Age: 54
 * Last name: Vang, First name: Winh, Age: 22
 * Last name: Creswell, First name: Lucinda, Age: 18
 * Found   Last name: Stimson, First name: Henry, Age: 29
 * Deleting smith, Yee, Creawell
 * Last name: Evans, First name: Patty, Age: 24
 * Last name: Smith, First name: Lorraine, Age: 37
 * Last name: Adams, First name: Henry, Age: 63
 * Last name: Hashimoto, First name: Sato, Age: 21
 * Last name: Stimson, First name: Henry, Age: 29
 * Last name: Velasquez, First name: Jose, Age: 72
 * Last name: Lamarque, First name: Henry, Age: 54
 * Last name: Vang, First name: Winh, Age: 22
 */