package com.example.demo.repository;

import com.example.demo.domain.Index;
import com.example.demo.domain.Student;
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
public class StudentRepository extends Student{

    @PersistenceContext
    EntityManager entityManager;

    StudentRepository(){};
    List<Student> students = new ArrayList<>();

    public StudentRepository(Student student) {
        super(student);
    }

    public StudentRepository(String name, String lastName, int age, int index) {
        super(name, lastName, age, index);
    }

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
