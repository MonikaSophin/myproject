package com.thinkinginjava.type_information.example.chapter14_8;

import com.thinkinginjava.util.Null;
import java.util.ArrayList;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/29
 * @description:
 */
class Person {
    public final String first;
    public final String last;
    public final String address;
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    @Override
    public String toString() { return String.format("[Person: %s %s %s]", first, last, address); }
    public static class NullPerson extends Person implements Null {
        private NullPerson() { super("None", "None", "None"); }
        @Override
        public String toString() { return "NullPerson"; }
    }
    public static final Person NULL = new NullPerson();
}


class Position {
    private String title;
    private Person person;
    public Position(String title, Person person) {
        this.title = title;
        this.person = person;
        if (person == null)
            this.person = Person.NULL;
    }
    public Position(String title) {
        this.title = title;
        this.person = Person.NULL;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) {
        this.person = person;
        if (person == null)
            this.person = Person.NULL;
    }
    @Override
    public String toString() {
        return String.format("{Position: %s %s}", title, person);
    }
}

public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) { add(new Position(title, person)); }
    public void add(String... titles) {
        for (String title : titles)
            add(new Position(title));
    }
    public Staff(String... titles) { add(titles); }
    public boolean positionAvailable(String title) {
        for (Position position : this)
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL)
                return true;
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this)
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL){
                position.setPerson(hire);
                return;
            }
        throw new RuntimeException(String.format("Position: %s not available"));
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO",
                "Marketing Manager", "Product Manager",
                "Project Lead", "Software Engineer",
                "Software Engineer", "Software Engineer",
                "Software Engineer", "Test Engineer",
                "Technical Writer");
        staff.fillPosition("President",
                new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosition("Project Lead",
                new Person("Janet", "Planner", "The Burbs"));
        if(staff.positionAvailable("Software Engineer"))
            staff.fillPosition("Software Engineer",
                    new Person("Bob", "Coder", "Bright Light City"));
        System.out.println(staff);
    }
}
/**output:
 * [{Position: President [Person: Me Last The Top, Lonely At]}, {Position: CTO NullPerson}, {Position: Marketing Manager NullPerson}, {Position: Product Manager NullPerson}, {Position: Project Lead [Person: Janet Planner The Burbs]}, {Position: Software Engineer [Person: Bob Coder Bright Light City]}, {Position: Software Engineer NullPerson}, {Position: Software Engineer NullPerson}, {Position: Software Engineer NullPerson}, {Position: Test Engineer NullPerson}, {Position: Technical Writer NullPerson}]
 */