package com.example.demo.service;

import com.example.demo.domain.Index;
import com.example.demo.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    IndexRepository indexRepository;


    public List<Index> getAllIndex() {
        return indexRepository.getAllIndex();
    }

    public void saveIndex(Index index) {
        indexRepository.saveIndex(index);
    }

   /* public void updateIndex(Index index) {
        indexRepository.updateIndex(index);
    }
    */
}
