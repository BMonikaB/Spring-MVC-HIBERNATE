package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentClassessService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentClassessService studentClassessService;

    @RequestMapping("/students")
    public String Student(Model model) {
        List<Student> studentList = studentRepository.list();
        model.addAttribute("allStudent", studentList);
        return "students";
    }

    @RequestMapping("/studentcreate")
    public String CreateStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentscreate";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String SaveStudent(Student student) {
        studentRepository.saveStudent(student);
        return "redirect:/students";
    }
}


