package com.example.demo.service;

import com.example.demo.domain.Classes;
import com.example.demo.domain.Student;
import com.example.demo.domain.University;
import com.example.demo.repository.ClassessRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class StudentClassessService {

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassessRepository classessRepository;



    @Transactional
    public void connectClassesStudent(){
        Classes polski = new Classes("Polski",20);
        Classes matematyka = new Classes("Matematyka",12);
        entityManager.persist(polski);
        entityManager.persist(matematyka);
        Student ala = entityManager.find(Student.class,1);
        Student joanna = entityManager.find(Student.class,3);
        polski.addStudent(ala);
        polski.addStudent(joanna);
        ala.addClassess(polski);
        matematyka.addStudent(joanna);
        joanna.addClassess(matematyka);
        joanna.addClassess(polski);

    }

    @Transactional
    public void connectUniversityStudent(){
        University pwr = new University("Pwr");
        University wroclawski = new University("Uniwerystet Wroclawski");
        entityManager.persist(wroclawski);
        entityManager.persist(pwr);
        Student ala = entityManager.find(Student.class,1);
        Student ola = entityManager.find(Student.class,3);
        ala.setUniversity(pwr);
        ola.setUniversity(wroclawski);
        pwr.addStudent(ala);
        pwr.addStudent(ola);

    }


}