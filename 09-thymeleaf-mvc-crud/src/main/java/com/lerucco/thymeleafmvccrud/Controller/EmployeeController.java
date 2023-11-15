package com.lerucco.thymeleafmvccrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.lerucco.thymeleafmvccrud.entity.Employee;
import com.lerucco.thymeleafmvccrud.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String listEmployee(Model model) {
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employee/list-employees";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee/create-employee";
    }
}
