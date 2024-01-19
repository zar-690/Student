package com.itvedant.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itvedant.student.entities.Student;



public interface StudentRepository extends JpaRepository<	Student, Integer> {

	List<Student> findByStudentName(String studentName);
	@Query(value = "select * from student order by student_name",nativeQuery = true)
	List<Student> sortByname();

}
