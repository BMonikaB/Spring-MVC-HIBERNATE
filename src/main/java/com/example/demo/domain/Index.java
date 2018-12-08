package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_index;
    @GeneratedValue
    private int indexNumber;
    @OneToOne(mappedBy = "index")
    private Student student;

    public Index(){

    }

    public Index (int index){
        this.indexNumber = index;
    }


    public Index(int id_index, int indexNumber, Student student) {
        this.id_index = id_index;
        this.indexNumber = indexNumber;
        this.student = student;
    }



    public int getId_index() {
        return id_index;
    }

    public int getId() {
        return id_index;
    }

    public void setId(int id) {
        this.id_index = id;
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
        return "Index{" + "id_index=" + id_index + ", indexNumber=" + indexNumber;
    }
}
