package com.example.demo.controller;

import com.example.demo.domain.Classes;
import com.example.demo.repository.ClassessRepository;
import com.example.demo.service.ClassesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClassesController {

    @Autowired
    ClassessRepository classessRepository;
    @Autowired
    ClassesServices classesServices;

    @RequestMapping("/classes")
    public String getAllClasses(Model model) {
        List<Classes> allClasses = classesServices.getClassesList();
        model.addAttribute("classes",allClasses);
        return "classes";
    }

    @RequestMapping("/classescreate")
    public String createClasses(Model model){
       model.addAttribute("classes",new Classes());
       return "classescreate";
    }

    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public String saveClasses(Classes classes){
        classesServices.saveClassess(classes);
        return "redirect:/classes";
    }

    @RequestMapping(value = "/classes/delete/{id_classes}")
    public String deleteClasses(@PathVariable("id_classes") Integer id_classes, Model model){
        classesServices.deleteClasses(id_classes);
        return "redirect:/classes";
    }

}
