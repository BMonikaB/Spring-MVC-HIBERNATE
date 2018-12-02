package com.example.demo.repository;

import com.example.demo.domain.Classes;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClassessRepository extends Classes {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addStudent(Student student) {
        super.addStudent(student);
    }
}
