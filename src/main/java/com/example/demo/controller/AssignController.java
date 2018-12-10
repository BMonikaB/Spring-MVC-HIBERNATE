package com.example.demo.controller;

import com.example.demo.domain.Classes;
import com.example.demo.domain.Index;
import com.example.demo.domain.Student;
import com.example.demo.domain.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.ClassesServices;
import com.example.demo.service.IndexService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class AssignController {


    @Autowired
    StudentService studentService;
    @Autowired
    UniversityService universityService;
    @Autowired
    IndexService indexService;
    @Autowired
    ClassesServices classesServices;
    @Autowired
    UniversityRepository universityRepository;

    //do uniwersytetu

    @GetMapping("/assignuniversity")
    public String assignUniversity1(@RequestParam("id") Integer id, Model model) {

        Student student = studentService.getOneStudents(id);
        List<University> universityList = universityService.getAllUniversityList();
        model.addAttribute("student", student);
        model.addAttribute("universityList", universityList);
        return "assignuniversity";
    }

    @PostMapping(value = "/assignuniversity")//, method = RequestMethod.POST)
    public String assignUniversity2(Student student, BindingResult bindingResult) {
        System.out.println(bindingResult);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    //do indeksu
    @GetMapping("/assignindex")
    public String assignIndex1(@RequestParam("id") Integer id, Model model) {

        Student student = studentService.getOneStudents(id);
        List<Index> indexList = indexService.getAllIndex();
        model.addAttribute("student", student);
        model.addAttribute("indexList", indexList);
        return "assignindex";
    }

    @PostMapping(value = "/assignindex")//, method = RequestMethod.POST)
    public String assignIndex2(Student student, BindingResult bindingResult) {
        System.out.println(bindingResult);
        studentService.updateStudent(student);
        return "redirect:/students";
    }



}
