package com.itvedant.student.dao;

public class AddStudentDao {
	
	private String studentName;
	private String address;
	private String email;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AddStudentDao [studentName=" + studentName + ", address=" + address + ", email=" + email + "]";
	}
	
}
