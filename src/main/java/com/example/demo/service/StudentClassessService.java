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
    public void createZaleznosc(){
        Classes polski = new Classes("Polski",20);
        entityManager.persist(polski);
        Student ala = entityManager.find(Student.class,1);
        polski.addStudent(ala);
        ala.addClassess(polski);

    }

    @Transactional
    public void poczaczenieZUniverek(){
        University pwr = new University("Pwr");
        University wroclawski = new University("Uniwerystet Wroclawski");
        entityManager.persist(wroclawski);
        entityManager.persist(pwr);
        Student ala = entityManager.find(Student.class,1);
        Student dwa = entityManager.find(Student.class,3);
        System.out.println(ala);
        System.out.println(dwa);
        ala.setUniversity(pwr);
        dwa.setUniversity(wroclawski);
        pwr.addStudent(ala);

    }


}
