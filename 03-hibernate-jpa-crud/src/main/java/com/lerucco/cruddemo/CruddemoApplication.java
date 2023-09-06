package com.lerucco.cruddemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lerucco.cruddemo.dao.StudentDAO;
import com.lerucco.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Executed after Spring Beans has been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// Java Lambda Expression
		return runner -> {
			System.out.println("Hello World");
			
			createMultipleStudents(studentDAO);

			Optional<Student> studentOptional = Optional.empty();
			studentOptional = Optional.ofNullable(readStudent(studentDAO, 10));
			if (studentOptional.isPresent())
				System.out.println(studentOptional.get().toString());
			else
				System.out.println("Empty");

			List<Student> students = readAllStudents(studentDAO);
			students.stream().forEach(t -> {
				System.out.println(t.toString());
			});
			System.out.print("------------------------\n");
			List<Student> studentsDoe = queryForStudentsByLastName(studentDAO);
			studentsDoe.stream().forEach(t -> {
				System.out.println(t.toString());
			});

			studentOptional = Optional.ofNullable(readStudent(studentDAO, 10));
			if (studentOptional.isPresent()) {
				Student student = studentOptional.get();
				System.out.println("Student want to updated : " + student.toString());
				student.setLastName(student.getLastName() + " Updated");
				Student newStudent = updateStudent(studentDAO, student);
				System.out.println("Student after updated : " + newStudent.toString());
			} else
				System.out.println("Empty");
			Student student = new Student("Kamen", "Rider", "Kamen@gmail.com");
			student = createStudent(studentDAO, student);
			System.out.println("Create Student : " + student.toString());
			deleteStudent(studentDAO, student.getId());
			System.out.println("Deleted Student : " + student.toString());
 
			deleteStudent(studentDAO, 90); // No Error 
			int numRowsDeleted = deleteAllStudents(studentDAO);
			System.out.println("Deleted All Students : " + numRowsDeleted + " rows");
		};
	}

	private List<Student> createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating new student object ");
		List<Student> students = Arrays.asList(
				new Student("Le", "koe", "koe@gmail.com"),
				new Student("Le", "wii", "wii@gmail.com"),
				new Student("kungfu", "panda", "panda@gmail.com"));
		System.out.println("Total new student : " + students.size());

		// Save the students objects
		System.out.println("Saving the students");
		students.stream().forEach((student) -> {
			studentDAO.save(student);
			// System.out.println(student.toString()); 
		});
		return students;
	}

	private Student createStudent(StudentDAO studentDAO, Student student) {
		// Create the student object
		System.out.println("Creating new student object ");
		
		// Save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		// Display id of the saved student
		System.out.println("Saved student. Generated id : " + student.getId());
		System.out.println(student.toString());
		return student;
	}

	private Student readStudent(StudentDAO studentDAO, Integer id) {
		// Retrieve student based on the id: primary key
		Student student = studentDAO.findById(id);
		return student;
	}

	private List<Student> readAllStudents(StudentDAO studentDAO) {
		return studentDAO.findAll();
	}

	private List<Student> queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get list of students
		return studentDAO.findByLastName("doe");
	}

	private Student updateStudent(StudentDAO studentDAO, Student student) {
		return studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO, Integer id) {
		studentDAO.delete(id);
	}

	private int deleteAllStudents(StudentDAO studentDAO) {
		return studentDAO.deleteAll();
	}
}
