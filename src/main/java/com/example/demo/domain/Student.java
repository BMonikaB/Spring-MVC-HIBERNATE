package com.example.demo.domain;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_student;
    private String name;
    private String lastName;
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    private Index index;
    @ManyToOne
    private University university;
    @ManyToMany
    private List<Classes> classes = new ArrayList<>();


    public Student(Student student){

    }



    public Student(String name, String lastName, int age, int index ){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.index = new Index(index);
        classes = new ArrayList<>();
    }

    public Student() {
    }

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName =lastName;
        this.age=age;
    }


    public void addClassess(Classes classes){
        this.classes.add(classes);
    }


    public int getId() {
        return id_student;
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

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public Index getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Student{" + "id_student=" + id_student + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age;
    }
}
