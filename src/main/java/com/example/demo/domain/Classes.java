package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameOfTheClass;
    @ManyToMany(mappedBy = "classes")
    private List<Student> studentList = new ArrayList<>();


    public Classes() {
    }

    public Classes(int id, String nameOfTheClass, List<Student> studentList) {
        this.id = id;
        this.nameOfTheClass = nameOfTheClass;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheClass() {
        return nameOfTheClass;
    }

    public void setNameOfTheClass(String nameOfTheClass) {
        this.nameOfTheClass = nameOfTheClass;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Classes{" + "id=" + id + ", nameOfTheClass='" + nameOfTheClass + '\'' + ", studentList=" + studentList + '}';
    }
}
