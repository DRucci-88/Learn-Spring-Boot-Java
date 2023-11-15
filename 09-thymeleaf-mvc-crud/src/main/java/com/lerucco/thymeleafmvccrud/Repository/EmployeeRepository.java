package com.lerucco.thymeleafmvccrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lerucco.thymeleafmvccrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
