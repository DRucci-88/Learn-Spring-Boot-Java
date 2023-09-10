package com.lerucco.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lerucco.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Voilaa no need to write any code
    // Minimaze EmployeeDAO and EmployeeDAOImple
}
