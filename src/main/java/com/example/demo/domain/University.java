package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String theNameOfTheUniversity;
    @OneToMany(mappedBy = "university")
    private List<Student> studentList = new ArrayList<>();

    public University() {
    }

    ;

    public University(String theNameOfTheUniversity) {
        this.theNameOfTheUniversity = theNameOfTheUniversity;

    }


    public void addStudent(Student student) {
        studentList.add(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheNameOfTheUniversity() {
        return theNameOfTheUniversity;
    }

    public void setTheNameOfTheUniversity(String theNameOfTheUniversity) {
        this.theNameOfTheUniversity = theNameOfTheUniversity;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    @Override
    public String toString() {
        return "University{" + "id=" + id + ", theNameOfTheUniversity='" + theNameOfTheUniversity;
    }


}
