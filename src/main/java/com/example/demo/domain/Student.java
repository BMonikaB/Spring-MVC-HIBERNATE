package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    private Index index;
    @ManyToOne
    private University university;
    @ManyToMany
    private List<Classes> classes = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String lastName, int age, int index) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.index = new Index(index);
        classes = new ArrayList<>();
    }

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public void addClassess(Classes classes) {
        this.classes.add(classes);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setIndex(Index index) {
        this.index = index;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }


    public Index getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Student{" + "id_student=" + id + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age;
    }
}