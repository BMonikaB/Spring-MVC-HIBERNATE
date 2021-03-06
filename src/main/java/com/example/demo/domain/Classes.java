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
    private int classroom;
    @ManyToMany(mappedBy = "classes")
    private List<Student> studentList;


    public Classes() {
    }


    public Classes(String nameOfTheClass, int classroom){
        this.nameOfTheClass= nameOfTheClass;
        this.classroom = classroom;
        this.studentList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNameOfTheClass() {
        return nameOfTheClass;
    }

    public void setNameOfTheClass(String nameOfTheClass) {
        this.nameOfTheClass = nameOfTheClass;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classes{" + "id_classess=" + id + ", nameOfTheClass='" + nameOfTheClass + '\'' + ", studentList=" + studentList + '}';
    }
}
