package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Startet  implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository ;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        studentRepository.createStudent();
        studentRepository.addStudent("Joanna","Ptak",10,98765);
       // studentRepository.deleteStudent(studentRepository.list().get(0));
    }
}
