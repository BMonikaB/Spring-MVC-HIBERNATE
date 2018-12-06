package com.example.demo.service;

import com.example.demo.domain.Classes;
import com.example.demo.repository.ClassessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServices {

    @Autowired
    ClassessRepository classessRepository;


    public void deleteClasses(Integer id_classes) {
        classessRepository.deleteClasses(id_classes);
    }

    public void saveClassess(Classes classes) {
        classessRepository.saveClassess(classes);
    }


    public List<Classes> getClassesList() {
        return classessRepository.getClassesList();
    }
}
