package com.itvedant.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.student.dao.AddStudentDao;
import com.itvedant.student.dao.UpdateStudentDao;
import com.itvedant.student.entities.Student;
import com.itvedant.student.repo.StudentRepository;

@Service
public class StudentServices {

	
	
	// to add Student inside Mysql
	
	@Autowired
	private StudentRepository studentRepository;
	
   public Student createStudent(AddStudentDao addStudentdao) {
	   
	   Student student = new Student();
	   
	   student.setStudentName(addStudentdao.getStudentName());
	   student.setAddress(addStudentdao.getAddress());
	   student.setEmail(addStudentdao.getEmail());
	   
	   studentRepository.save(student);
	   return student;
}
   
   // to get student from my sql
   
   public Iterable<Student> getAllStudent(){
	   return this.studentRepository.findAll();
   }
   
// To get specific student  from mysql
	
	
	
	public Student getStudentByid(Integer id) {
		
		Student student = this.studentRepository.findById(id).orElse(null);
		
		if(student == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Does not Exist");
		}
		return student;
	}
	
	

		
		// To delete the specfic student form mysql
		
		public void deleteStudent(Integer id) {
			
			Student student = this.studentRepository.findById(id).orElse(null);
			
			if(student == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Does not Exist");
			}
			
			this.studentRepository.delete(student);
		}
		
		
		
	
		
		
		// to update the student from Mysql
		
		public Student updateStudent(Integer id, UpdateStudentDao updateStudentDao) {
			Student student = this.getStudentByid(id);
			
			if(updateStudentDao.getStudentName() !=null) {
				student.setStudentName(updateStudentDao.getStudentName());
			}
			if(updateStudentDao.getEmail() !=null) {
				student.setEmail(updateStudentDao.getEmail());
			}
			if(updateStudentDao.getAddress() !=null) {
				student.setAddress(updateStudentDao.getAddress());
			}
			
			this.studentRepository.save(student);
			
			return student;
		}
		
		
		
		
		
		// to find the product by Product Name
		public List<Student> getByStudentName(String studentName){
			return this.studentRepository.findByStudentName(studentName);
		}
		
		
		// to sort the product by name
		public List<Student> sortByStudentName(){
			return this.studentRepository.sortByname();
		}
		
}