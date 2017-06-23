package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        People p1 = new People("E", 1);
        People p2 = new People("F", 2);
        People p3 = new People("G", 3);
        People p4 = new People("H", 4);
        List<People> peopleList = new ArrayList<>();
        peopleList.add(p1);
        peopleList.add(p2);
        peopleList.add(p3);
        peopleList.add(p4);
        Collections.sort(peopleList,new MyComparator());
        for (People p : peopleList
                ) {
            System.out.println(p.name + p.age);
        }




        Person ps1 = new Person("A", 1);
        Person ps2 = new Person("B", 2);
        Person ps3 = new Person("C", 3);
        Person ps4 = new Person("D", 4);
        List<Person> personList = new ArrayList<>();
        personList.add(ps1);
        personList.add(ps2);
        personList.add(ps3);
        personList.add(ps4);
        Collections.sort(personList);
        for (Person p : personList
                ) {
            System.out.println(p.name + p.age);
        }


    }
}

class Person implements Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person person) {
        return person.age-this.age;
    }
}

class People {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class MyComparator implements Comparator<People>{


    @Override
    public int compare(People people, People t1) {
        return t1.age - people.age;
    }
}
