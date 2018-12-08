package com.example.demo.repository;

import com.example.demo.domain.Index;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IndexRepository {


    @PersistenceContext
    EntityManager entityManager;

    private List<Index> indexList = new ArrayList<>();

    IndexRepository() {

    }

    ;


    @Transactional
    public void addIndex(int index) {
        Index index1 = new Index(index);
        entityManager.persist(index1);
          indexList.add(index1);
           indexList.add(index1);
    }


    @Transactional
    public void buildIndex() {
        addIndex(12345);
        addIndex(78901);

    }

    @Transactional
    public List<Index> getIndexList() {
        return indexList;
    }

    @Transactional
    public List<Index> getAllIndex() {
        return entityManager.createQuery("from Index", Index.class).getResultList();
    }

    @Transactional
    public void saveIndex(Index index) {
        addIndex(index.getId_index());
    }


}
