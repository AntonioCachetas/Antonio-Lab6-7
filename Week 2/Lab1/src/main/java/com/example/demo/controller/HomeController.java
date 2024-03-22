package com.example.demo.controller;

import com.example.demo.controller.com.example.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Antonio Cachetas");
        model.addAttribute("studentNumber", "N01563558");
        return "index";
    }
    
    @GetMapping("/student")
    public String student(Model model) {
        Student student = new Student("John Doe", "S123456");
        model.addAttribute("student", student);
        return "student";
    }
}
