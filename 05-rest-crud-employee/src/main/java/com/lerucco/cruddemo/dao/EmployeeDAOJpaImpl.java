// package com.lerucco.cruddemo.dao;

// import java.util.List;

// import org.springframework.stereotype.Repository;

// import com.lerucco.cruddemo.entity.Employee;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.TypedQuery;

// @Repository
// public class EmployeeDAOJpaImpl implements EmployeeDAO {

// private EntityManager entityManager;

// public EmployeeDAOJpaImpl(EntityManager entityManager) {
// this.entityManager = entityManager;
// }

// @Override
// public List<Employee> findAll() {
// TypedQuery<Employee> query = entityManager.createQuery("FROM Employee",
// Employee.class);

// List<Employee> employees = query.getResultList();
// return employees;
// }

// @Override
// public Employee findById(int id) {
// Employee employee = entityManager.find(Employee.class, id);
// return employee;
// }

// @Override
// public Employee save(Employee employee) {
// // If id == 0 then insert/save else update
// Employee dbEmployee = entityManager.merge(employee);
// return dbEmployee;
// }

// @Override
// public void deleteById(int id) {
// Employee employee = entityManager.find(Employee.class, id);
// entityManager.remove(employee);
// }

// }
