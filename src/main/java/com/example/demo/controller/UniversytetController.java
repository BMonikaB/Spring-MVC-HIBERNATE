package com.example.demo.controller;

import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UniversytetController {


    @Autowired
    UniversityService universityService;

    @GetMapping("/universities")
    public String allUniversities(Model model) {
        List<University> universityList = universityService.getAllUniversityList();
        model.addAttribute("alluniversity", universityList);
        return "universities";
    }

    @GetMapping("/universitycreate")
    public String createUniversity(Model model) {
        model.addAttribute("createUniversity", new University());
        return "universitycreate";
    }

    @PostMapping(value = "/universities")//, method = RequestMethod.POST)
    public String saveUniversity(University university) {
        universityService.saveUniversity(university);
        return "redirect:/universities";
    }

    @GetMapping(value = "/university/delete/{id}")
    public String deleteUniversity(@PathVariable("id") Integer id) {
        universityService.deleteUniversity(id);
        return "redirect:/universities";
    }
}
