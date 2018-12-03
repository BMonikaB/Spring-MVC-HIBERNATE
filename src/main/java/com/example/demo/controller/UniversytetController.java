package com.example.demo.controller;

import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class UniversytetController {

    @Autowired
    UniversityRepository universityRepository;

    @RequestMapping("/universities")
    public String allUniversities(Model model){
        List<University> universityList = universityRepository.getAllUniversityList();
        model.addAttribute("alluniversity",universityList);
        return "universities";
    }

    @RequestMapping("/universitycreate")
    public String createUniversity(Model model){
        model.addAttribute("createUniversity", new University());
        return "universitycreate";
    }

    @RequestMapping(value = "/universities", method = RequestMethod.POST)
    public String saveUniversity(University university){
        universityRepository.saveUniversity(university);
        return "redirect:/universities";
    }
}
