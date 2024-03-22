package org.humber.ClassroomSpringBootApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping("/a")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        model.addAttribute("numbers", Arrays.asList(1,2,3,4,5));
        return "index";
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello world";
    }

}
