package com.website.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.lms.Repository.StudentRepository;
import com.website.lms.Service.StudentService;
import com.website.lms.dto.SaveSuccessStatus;
import com.website.lms.dto.SignupSuccessStatus;
import com.website.lms.entity.Student;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping
	public ResponseEntity<SaveSuccessStatus> save(@RequestBody Student student)
	{
		studentService.save(student);
		SaveSuccessStatus saveSuccessStatus = new SaveSuccessStatus();
		saveSuccessStatus.setMessage("Data saved Successfully");
		saveSuccessStatus.setStatus(true);
		return ResponseEntity.ok(saveSuccessStatus);
	}
	
	
	@GetMapping
	public Iterable<Student>get()
	{
		return studentService.get();
	}
	
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable Integer id)
	{
		return studentService.getById(id);
	}
	
	
	@PutMapping
	public Student update(@RequestBody Student student)
	{
		Student data = studentRepository.findById(student.getId()).get();
		data.setFirstName(student.getFirstName());
		data.setLastName(student.getLastName());
		data.setContactNumber(student.getContactNumber());
		data.setGraduation(student.getGraduation());
		data.setPassingYear(student.getPassingYear());
		data.setPassword(student.getPassword());
		return studentService.save(student);
	}
	
	
	
	
	
	
}
