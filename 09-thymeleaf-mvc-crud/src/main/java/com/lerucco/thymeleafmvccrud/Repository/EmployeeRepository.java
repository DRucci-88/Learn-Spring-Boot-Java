package com.lerucco.thymeleafmvccrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lerucco.thymeleafmvccrud.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
