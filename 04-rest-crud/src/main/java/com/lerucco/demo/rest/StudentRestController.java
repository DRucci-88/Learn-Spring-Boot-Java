package com.lerucco.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lerucco.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // Define @PostConstruct to load the student ONLY ONCE
    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();
        students.add(new Student("Le", "Rucco"));
        students.add(new Student("Le", "Java"));
        students.add(new Student("Le", "Kotlin"));
        students.add(new Student("La", "Purple"));
    }

    // Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // Define endpoint for "/student/{id}" - return student at index
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {

        return Optional.ofNullable(students.get(id)).orElse(null);
    }
}
