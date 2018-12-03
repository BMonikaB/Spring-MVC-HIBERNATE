package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_University;
    private String theNameOfTheUniversity;
    @OneToMany(mappedBy = "university")
    private Set<Student> studentList;

    public University() {
    }

    ;
    public University(String theNameOfTheUniversity) {
        this.theNameOfTheUniversity = theNameOfTheUniversity;
        studentList = new HashSet<>();
    }

    public int getId_University() {
        return id_University;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setId_University(int id_University) {
        this.id_University = id_University;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }



    public int getId() {
        return id_University;
    }

    public void setId(int id) {
        this.id_University = id;
    }

    public String getTheNameOfTheUniversity() {
        return theNameOfTheUniversity;
    }

    public void setTheNameOfTheUniversity(String theNameOfTheUniversity) {
        this.theNameOfTheUniversity = theNameOfTheUniversity;
    }


    @Override
    public String toString() {
        return "University{" + "id=" + id_University + ", theNameOfTheUniversity='" + theNameOfTheUniversity + '\'' + ", studentList=" + studentList + '}';
    }


}
