package com.example.demo;

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

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        studentRepository.createStudent();
        studentRepository.addStudent("Joanna","Ptak",10,98765);
        studentClassessService.createZaleznosc();
        studentClassessService.poczaczenieZUniverek();

    }


}
