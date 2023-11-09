package com.lerucco.thymeleafmvccrud.Service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lerucco.thymeleafmvccrud.Entity.Employee;
import com.lerucco.thymeleafmvccrud.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    // @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employeeOptional.get();
    }

    public Employee update(Employee updatedEmployee, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        Employee employee = employeeOptional.get();

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        return employeeRepository.save(employee);
    }

    public String deleteById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        employeeRepository.deleteById(id);

        return "Deleted employee id - " + id;
    }
}