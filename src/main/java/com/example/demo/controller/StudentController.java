package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentClassessService;
import com.example.demo.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String Student(Model model) {
        List<Student> studentList = studentService.list();
        model.addAttribute("allStudent", studentList);
        return "students";
    }

    @GetMapping("/studentcreate")
    public String CreateStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentscreate";
    }

    @PostMapping(value = "/students")//, method = RequestMethod.POST)
    public String SaveStudent(@Valid Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            System.out.println("Tu jest blad");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "studentscreate";
        }
        else {

            studentService.saveStudent(student);
            return "redirect:/students";
        }
    }

    @GetMapping(value = "/students/showMore/{id}")
    public String showMore(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.getOneStudents(id);
        model.addAttribute("student", student);
        return "showmorestudent";
    }


    @GetMapping(value = "/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}


