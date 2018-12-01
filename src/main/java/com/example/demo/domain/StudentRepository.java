package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;


    List<Student> students = new ArrayList<>();

    public void showStudents(){
        for (Student s : students){
            System.out.println(students);
        }
    }

    @Transactional
    public void addStudent(String name, String lastName, int age, int index){
        Student student = new Student(name,lastName,age,index);
        entityManager.persist(student);
        students.add(student);
    }


    @Transactional
    public void createStudent(){
        addStudent("Anna","Kot",10,12345);
    }

    @Transactional
    public void deleteStudent(Student student){
       entityManager.remove(student);
    }

    @Transactional
    public List<Student> list(){
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }


    @Override
    public String toString() {
        return "StudentRepository{" + "entityManager=" + entityManager + '}';
    }
}
