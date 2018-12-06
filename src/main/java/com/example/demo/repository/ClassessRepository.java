package com.example.demo.repository;

import com.example.demo.domain.Classes;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClassessRepository extends Classes {

    @PersistenceContext
    EntityManager entityManager;


    public List<Classes> classesList = new ArrayList<>();

    @Transactional
    public void addClasses(String nameOfTheClass,int classroom){
        Classes classes = new Classes(nameOfTheClass,classroom);
        entityManager.persist(classes);
        classesList.add(classes);
    }

    @Transactional
    public void deleteClasses(int id_classes){
        Classes classes = entityManager.find(Classes.class, id_classes);
        entityManager.remove(classes);
    }

    @Transactional
    public void saveClassess(Classes classes){
        addClasses(classes.getNameOfTheClass(),classes.getClassroom());
    }

    @Transactional
    public List<Classes> getClassesList(){
        return entityManager.createQuery("from Classes",Classes.class).getResultList();
    }



}
