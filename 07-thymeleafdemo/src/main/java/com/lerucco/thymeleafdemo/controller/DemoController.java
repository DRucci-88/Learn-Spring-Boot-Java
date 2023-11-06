package com.lerucco.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    // Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld"; // src/main/resources/templates/helloworld.html

        // We have Thymeleaf dependency in Maven POM
        // Spring Boot will auto-configure to use Thymeleaf
    }
}
