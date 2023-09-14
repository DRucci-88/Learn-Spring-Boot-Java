package com.lerucco.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lerucco.cruddemo.entity.Employee;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Voilaa no need to write any code
    // Minimaze EmployeeDAO and EmployeeDAOImple
}
