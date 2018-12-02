package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_classes;
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

    public void addStudent(Student student){
        this.studentList.add(student);
    }



    @Override
    public String toString() {
        return "Classes{" + "id_classess=" + id_classes + ", nameOfTheClass='" + nameOfTheClass + '\'' + ", studentList=" + studentList + '}';
    }
}
