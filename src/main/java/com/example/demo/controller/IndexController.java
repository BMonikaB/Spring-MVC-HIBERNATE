package com.example.demo.controller;

import com.example.demo.domain.Index;
import com.example.demo.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    IndexRepository indexRepository;


    @RequestMapping("/indexes")
    public String getAllIndexes(Model model) {
        List<Index> indexList = indexRepository.getAllIndex();
        model.addAttribute("allindex", indexList);
        return "indexes";
    }

}
