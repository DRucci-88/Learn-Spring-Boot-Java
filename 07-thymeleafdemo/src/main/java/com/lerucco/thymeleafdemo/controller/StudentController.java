package com.lerucco.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lerucco.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // Create a new Student Object
        Student student = new Student();

        // Add student object as a Model Attribute
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student, Model model) {

        System.out.println("Student : " + student.getFirstName() + " " + student.getLastName());
        model.addAttribute("student", student);
        return "student-confirmation";
    }
}
