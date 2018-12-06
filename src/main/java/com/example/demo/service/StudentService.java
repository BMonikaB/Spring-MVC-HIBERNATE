package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public void deleteStudent(Integer id){
        studentRepository.deleteStudent(id);
    }


    public Student getOneStudents(Integer id) {
        return studentRepository.getOneStudents(id);
    }

    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public List<Student> list() {
        return studentRepository.list();
    }
}
