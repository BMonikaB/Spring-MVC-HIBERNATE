package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository extends Student {

    @PersistenceContext
    EntityManager entityManager;

    private List<Student> students =  new ArrayList<>();

    StudentRepository() {
    }

    public StudentRepository(String name, String lastName, int age, int index) {
        super(name, lastName, age, index);
    }

    @Transactional
    public void addStudent(String name, String lastName, int age, int index) {
        Student student = new Student(name, lastName, age, index);
        entityManager.persist(student);
        students.add(student);
        students.add(student);
    }


    @Transactional
    public void addStudent(String name, String lastName, int age) {
        Student student = new Student(name, lastName, age);
        entityManager.persist(student);
        students.add(student);
    }

    @Transactional
    public void createStudent() {
        addStudent("Anna", "Kot", 10, 12345);
        addStudent("Joanna","Ptak",10,98765);
    }

    @Transactional
    public List<Student> list() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Transactional
    public void saveStudent(Student student) {
        addStudent(student.getName(), student.getLastName(), student.getAge());
    }


    public Student getOneStudents(Integer id) {
        return students.get(id);
    }


    @Transactional
    public void deleteStudent(int id){
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }






}
