package com.lerucco.cruddemo.dao;

import java.util.List;

import com.lerucco.cruddemo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
