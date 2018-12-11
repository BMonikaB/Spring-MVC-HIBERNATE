package com.example.demo.service;

import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {


    @Autowired
    UniversityRepository universityRepository;


    public void deleteUniversity(Integer id) {
        universityRepository.deleteUniversity(id);
    }

    public void saveUniversity(University university) {
        universityRepository.saveUniversity(university);
    }

    public List<University> getAllUniversityList() {
        return universityRepository.getAllUniversityList();
    }

    public void updateUniversity(University university) {
        universityRepository.updateUniversity(university);
    }

    public University getOneUniversity(Integer id) {
       return universityRepository.getOneUniversity(id);
    }
}
