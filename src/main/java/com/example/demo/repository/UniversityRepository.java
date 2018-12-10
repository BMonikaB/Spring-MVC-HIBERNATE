package com.example.demo.repository;

import com.example.demo.domain.Student;
import com.example.demo.domain.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityRepository {

    @PersistenceContext
    EntityManager entityManager;



    @Transactional
    public void addUniversity(String theNameOfTheUniversity) {
        University one = new University(theNameOfTheUniversity);
        entityManager.persist(one);
    }

    @Transactional
    public void createUniversity() {
        addUniversity("Uniwersytet przyrodniczy");
    }

    @Transactional
    public void deleteUniversity(int id) {
        University university = entityManager.find(University.class, id);
        entityManager.remove(university);
    }


    public List<University> getAllUniversityList() {
        return entityManager.createQuery("from University", University.class).getResultList();
    }

    @Transactional
    public void saveUniversity(University university) {
        addUniversity(university.getTheNameOfTheUniversity());
    }


    @Transactional
    public void updateUniversity(University university) {
        entityManager.merge(university);
    }


    public University getOneUniversity(int id){
       return entityManager.createQuery("from University k where k.id=id", University.class).setParameter("id",id).getSingleResult();
    }
}