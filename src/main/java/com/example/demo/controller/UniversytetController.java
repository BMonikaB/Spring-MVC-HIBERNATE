package com.example.demo.controller;

import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UniversytetController {

    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    UniversityService universityService;

    @RequestMapping("/universities")
    public String allUniversities(Model model) {
        List<University> universityList = universityService.getAllUniversityList();
        model.addAttribute("alluniversity", universityList);
        return "universities";
    }

    @RequestMapping("/universitycreate")
    public String createUniversity(Model model) {
        model.addAttribute("createUniversity", new University());
        return "universitycreate";
    }

    @RequestMapping(value = "/universities", method = RequestMethod.POST)
    public String saveUniversity(University university) {
        universityService.saveUniversity(university);
        return "redirect:/universities";
    }

    @RequestMapping(value = "/university/delete/{id_University}")
    public String deleteUniversity(@PathVariable("id_University") Integer id_University, Model model) {
        universityService.deleteUniversity(id_University);
        return "redirect:/universities";
    }
}
