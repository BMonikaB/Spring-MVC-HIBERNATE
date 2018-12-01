package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int indexNumber;
    @OneToOne(mappedBy = "index")
    private Student student;

    public Index(){};

    public Index(int id, int indexNumber, Student student) {
        this.id = id;
        this.indexNumber = indexNumber;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Index{" + "id=" + id + ", indexNumber=" + indexNumber + ", student=" + student + '}';
    }
}
