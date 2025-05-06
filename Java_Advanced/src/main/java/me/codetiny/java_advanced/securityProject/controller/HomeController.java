package me.codetiny.java_advanced.securityProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // home.html로 이동
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html로 이동
    }
}
