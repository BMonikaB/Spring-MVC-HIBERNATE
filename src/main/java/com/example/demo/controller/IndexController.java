package com.example.demo.controller;

import com.example.demo.domain.Index;
import com.example.demo.repository.IndexRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
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

    @RequestMapping("/indexcreate")
    public String createIndex(Model model){
        model.addAttribute("index", new Index());
        return "indexcreate";
    }

    @RequestMapping(value = "/indexes",method = RequestMethod.POST)
    public String saveIndex(Index index){
        indexRepository.saveIndex(index);
        return "redirect:/indexes";
    }

}
