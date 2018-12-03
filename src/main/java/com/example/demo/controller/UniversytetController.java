package com.example.demo.controller;

import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
