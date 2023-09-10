package com.lerucco.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lerucco.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Le", "Rucco"));
        students.add(new Student("Le", "Java"));
        students.add(new Student("Le", "Kotlin"));
        return students;
    }
}
