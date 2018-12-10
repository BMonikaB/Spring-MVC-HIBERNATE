package com.example.demo.controller;

import com.example.demo.domain.Index;
import com.example.demo.repository.IndexRepository;
import com.example.demo.service.IndexService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
   IndexRepository indexRepository;


    @GetMapping("/indexes")
    public String getAllIndexes(Model model) {
        List<Index> indexList = indexRepository.getAllIndex();
        model.addAttribute("allindex", indexList);
        return "indexes";
    }

    @GetMapping("/indexcreate")
    public String createIndex(Model model){
        model.addAttribute("indeksy", new Index());
        return "indexcreate";
    }

    @PostMapping(value = "/indexes")//,method = RequestMethod.POST)
    public String saveIndex(Index index){
        indexRepository.saveIndex(index);
        return "redirect:/indexes";
    }

}
