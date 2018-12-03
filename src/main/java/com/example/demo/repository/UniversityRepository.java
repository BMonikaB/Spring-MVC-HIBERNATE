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

    public University university;

    List<University> universityList = new ArrayList<>();

    @Transactional
    public void addUniversity(String theNameOfTheUniversity) {
        University one = new University(theNameOfTheUniversity);
        entityManager.persist(one);
        universityList.add(one);
    }

    @Transactional
    public void createUniversity(){
        addUniversity("Uniwersytet przyrodniczy");
    }

    @Transactional
    public void deleteUniversity(University university){
        universityList.remove(university);
        entityManager.remove(university);
    }

    @Transactional
    public List<University> getAllUniversityList(){
        return entityManager.createQuery("from University", University.class).getResultList();
    }

    @Transactional
    public void saveUniversity(University university){
        addUniversity(university.getTheNameOfTheUniversity());
    }

    @Override
    public String toString() {
        return "UniversityRepository{" + "entityManager=" + entityManager + ", university=" + university + ", universityList=" + universityList + '}';
    }
}
