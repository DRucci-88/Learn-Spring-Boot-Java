package com.lerucco.cruddemo.dao;

import com.lerucco.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    Student update(Student student);
    void delete(Integer id);

    int deleteAll();
}
