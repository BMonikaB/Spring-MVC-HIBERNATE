package com.example.demo;

import com.example.demo.repository.IndexRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.StudentClassessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Startet  implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository ;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    StudentClassessService studentClassessService;
    @Autowired
    IndexRepository indexRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        studentRepository.createStudent();
        studentRepository.addStudent("Joanna","Ptak",10,98765);
        studentClassessService.connectClassesStudent();
        studentClassessService.connectUniversityStudent();

        System.out.println("Wszystko");
        studentRepository.showStudents();
        System.out.println(studentRepository.list());
        System.out.println(universityRepository.getAllUniversityList());

        System.out.println("Wszystkie indeksy");
        System.out.println(indexRepository.getAllIndex());


    }


}