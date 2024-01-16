package com.atd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.entity.StudentEntity;
import com.atd.service.StudentService;

@RestController
@RequestMapping("/atdstudent")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping(value = "/addStudent", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity studententity)
	{
		
		StudentEntity student = service.saveStudent(studententity);
		return new ResponseEntity<StudentEntity>(student, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/updateStudent", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateStudent(@RequestBody StudentEntity studententity)
	{
		String studentE = service.updateStudent(studententity);
		return new ResponseEntity<String>(studentE, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getStudent", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<StudentEntity>> getStudent()
	{
		 List<StudentEntity> allStudent = service.gellAllStudent();
		return new ResponseEntity<List<StudentEntity>>(allStudent, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getStudent/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable String id)
	{
		StudentEntity studentE = service.getStudent(Integer.parseInt(id));
		return new ResponseEntity<StudentEntity>(studentE, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteStudent/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteStudentById(@PathVariable String id)
	{
        String string = service.deleteStudent(Integer.parseInt(id));
		return new ResponseEntity<String>(string, HttpStatus.OK);
	}
	
	
}

