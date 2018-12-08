package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.University;
import com.example.demo.service.StudentService;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;
@Controller
public class AssignController {


    @Autowired
    StudentService studentService;
    @Autowired
    UniversityService universityService;

    @RequestMapping("/assignuniversity")
    public String assignUniversity1(@RequestParam("id") Integer id, Model model){

      Student student = studentService.getOneStudents(id);
       List<University> universityList = universityService.getAllUniversityList();
       model.addAttribute("student",student);
       model.addAttribute("universityList",universityList);
        return "assignuniversity";
    }

    @RequestMapping(value = "/assignuniversity",method = RequestMethod.POST)
    public String assignUniversity2(Student student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }




}
