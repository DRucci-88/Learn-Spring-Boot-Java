package com.lerucco.cruddemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lerucco.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    // @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional // because performing an update
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    // @Transactional // No need because doing just a query and not update / create
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student order by
        // lastName desc", Student.class);

        // Return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create Query
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData",
                Student.class);

        // Set query parameters
        query.setParameter("theData", lastName);

        // Return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        // TypedQuery<Student> query = entityManager.createQuery(
        // "FROM Student ",
        // Student.class
        // );
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Student> studentOptional = Optional.ofNullable(entityManager.find(Student.class, id));
        if (studentOptional.isPresent())
            entityManager.remove(studentOptional.get());
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery(
            "DELETE FROM Student"
        ).executeUpdate();
        return numRowsDeleted;
    }
}
