package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstPage {


    @RequestMapping("/firstpage")
    public String firstPage(Model model) {

        return "firstpage";
    }


}