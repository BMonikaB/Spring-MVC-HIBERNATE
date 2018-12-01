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
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Index index;
    @ManyToOne
    private University university;
    @ManyToMany
    private List<Classes> classes = new ArrayList<>();

    Student(int i, String anna, String kot, int i1) {
    }

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(String name, String lastName, int age, int id){
        this.id = id;
    }

    public Student(int id, String name, String lastName, int age, Index index) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Index getIndex() {
        return index;
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

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + ", address=" + address + ", index=" + index + '}';
    }
}
