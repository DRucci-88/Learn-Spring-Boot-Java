package com.lerucco.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class HelloWorldController {

    // Create controller to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        List<String> students = new ArrayList<>(Arrays.asList("John Doe", "Cameron", "Le Rucco"));
        model.addAttribute("students", students);
        return "helloworld-form";
    }

    // Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(Model model) {
        model.addAttribute("theDate", new java.util.Date());

        // String studentName = model.getAttribute("studentName").toString();
        String studentName = String.valueOf(model.getAttribute("studentName"));
        System.out.println(studentName);

        model.addAttribute("studentName", studentName);
        return "helloworld";
    }

    @RequestMapping("/processFormv2")
    public String processFormv2(HttpServletRequest request, Model model) {
        // Read the request parameter from the HTML form
        String studentName = request.getParameter("studentName");

        // Convert data to uppercase
        studentName = studentName.toUpperCase();

        // Create the message
        String result = "Form v2 " + studentName;

        // Add message to the model
        model.addAttribute("messagev2", result);
        return "helloworld";
    }

    @RequestMapping("/processFormv3")
    public String processFormv3(@RequestParam("studentName") String studentName, Model model) {
        studentName = studentName.toUpperCase();

        // Create the message
        String result = "Form v3 " + studentName;

        // Add message to the model
        model.addAttribute("messagev3", result);

        return "helloworld";
    }
}
