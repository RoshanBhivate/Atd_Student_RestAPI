package com.atd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.atd.entity.StudentEntity;
import com.atd.repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	
	//for inserting student
	@Override
	public StudentEntity saveStudent(StudentEntity studententity) {
		
		 StudentEntity save = studentRepo.save(studententity);
		 return save;
	}
	
	
    //for retrieving all student
	@Override
	public List<StudentEntity> gellAllStudent() {
		
		List<StudentEntity> findAll = studentRepo.findAll();
		
		return findAll;
	}
    //to retrive single student
	@Override
	public StudentEntity getStudent(Integer sid) {
	StudentEntity findBy = studentRepo.findById(sid).orElseThrow(() -> new RuntimeException("Student not found with id: " + sid));
	return findBy;
	}
	
	
	
	@Override
	public String updateStudent(StudentEntity studentEntity) {
		Optional<StudentEntity> findById = studentRepo.findById(studentEntity.getSid());
		
		if(findById.isPresent())
		{
			StudentEntity entity = findById.get(); 
			entity.setSname(studentEntity.getSname());
			entity.setCity(studentEntity.getCity());
			entity.setCourse(studentEntity.getCourse());
			entity.setGrade(studentEntity.getGrade());
			
			StudentEntity updatedStudent = studentRepo.save(entity);
			return "Student details Updated successfully";
						
		}
		else {
			return "Student not Found";
		}
	}
	


	@Override
    public String deleteStudent(Integer sid) {
        Optional<StudentEntity> findById = studentRepo.findById(sid);

        if (findById.isPresent()) {
            studentRepo.deleteById(sid);
            return "Student with id " + sid + " is deleted";
        } else {
            return "Student with id " + sid + " not found";
        }
    }
}