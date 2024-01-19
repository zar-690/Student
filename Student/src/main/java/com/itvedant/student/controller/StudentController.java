package com.itvedant.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.itvedant.student.dao.AddStudentDao;
import com.itvedant.student.dao.UpdateStudentDao;
import com.itvedant.student.services.StudentServices;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServices studentService;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddStudentDao addStudentdao){
		return ResponseEntity.ok(this.studentService.createStudent(addStudentdao));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllStudent(){
		return ResponseEntity.ok(this.studentService.getAllStudent());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.studentService.getStudentByid(id));
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id){
		this.studentService.deleteStudent(id);
		return "Student has been Deleted";
		
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UpdateStudentDao updateStudentDao){
		return ResponseEntity.ok(this.studentService.updateStudent(id, updateStudentDao));
	}
	
	@GetMapping("/search/findbystudentname")
	public ResponseEntity<?> findByName(@RequestParam String studentname){
		return ResponseEntity.ok(this.studentService.getByStudentName(studentname));
	}
	

    @GetMapping("/search/sortbyname")
    public ResponseEntity<?> sortName(){
	return ResponseEntity.ok(this.studentService.sortByStudentName());
}
}
	
