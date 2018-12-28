package com.data_structures_and_algorithms.simple_sort.example;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/26
 * @description: 清单3.4 对象排序
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

class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            a[i].displayPerson();
        System.out.println();
    }

    //插入排序
    public void insertionSort() {
        int out, in;
        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            while (in > 0 && a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }
}

public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb arr;
        arr = new ArrayInOb(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);
        System.out.println("Before sorting:");
        arr.display();

        arr.insertionSort();
        System.out.println("After sorting:");
        arr.display();
    }
}
/**output:
 * Before sorting:
 *   Last name: Evans, First name: Patty, Age: 24
 *   Last name: Smith, First name: Doc, Age: 59
 *   Last name: Smith, First name: Lorraine, Age: 37
 *   Last name: Smith, First name: Paul, Age: 37
 *   Last name: Yee, First name: Tom, Age: 43
 *   Last name: Hashimoto, First name: Sato, Age: 21
 *   Last name: Stimson, First name: Henry, Age: 29
 *   Last name: Velasquez, First name: Jose, Age: 72
 *   Last name: Vang, First name: Minh, Age: 22
 *   Last name: Creswell, First name: Lucinda, Age: 18
 *
 * After sorting:
 *   Last name: Creswell, First name: Lucinda, Age: 18
 *   Last name: Evans, First name: Patty, Age: 24
 *   Last name: Hashimoto, First name: Sato, Age: 21
 *   Last name: Smith, First name: Doc, Age: 59
 *   Last name: Smith, First name: Lorraine, Age: 37
 *   Last name: Smith, First name: Paul, Age: 37
 *   Last name: Stimson, First name: Henry, Age: 29
 *   Last name: Vang, First name: Minh, Age: 22
 *   Last name: Velasquez, First name: Jose, Age: 72
 *   Last name: Yee, First name: Tom, Age: 43
 */