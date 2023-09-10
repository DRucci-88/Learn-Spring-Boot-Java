package com.lerucco.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lerucco.cruddemo.dao.EmployeeRepository;
// import com.lerucco.cruddemo.dao.EmployeeDAO;
import com.lerucco.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent())
            throw new RuntimeException("Did not find employee id - " + id);
        return employeeOptional.get();
    }

    @Override
    // @Transactional // Since JpaRepository provides this functionality
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    // @Transactional // Since JpaRepository provides this functionality
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    // private EmployeeDAO employeeDAO;

    // public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    // this.employeeDAO = employeeDAO;
    // }

    // @Override
    // public List<Employee> findAll() {
    // return employeeDAO.findAll();
    // }

    // @Override
    // public Employee findById(int id) {
    // return employeeDAO.findById(id);
    // }

    // @Override
    // @Transactional
    // public Employee save(Employee employee) {
    // return employeeDAO.save(employee);
    // }

    // @Override
    // @Transactional
    // public void deleteById(int id) {
    // employeeDAO.deleteById(id);
    // }
}
