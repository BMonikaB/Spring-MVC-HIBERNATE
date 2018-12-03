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

    Classes classes = new Classes();




}
