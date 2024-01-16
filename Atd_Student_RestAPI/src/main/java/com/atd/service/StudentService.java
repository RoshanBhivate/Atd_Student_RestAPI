package com.atd.service;

import java.util.List;



import com.atd.entity.StudentEntity;

public interface StudentService {

	public StudentEntity saveStudent(StudentEntity studententity);

	public List<StudentEntity> gellAllStudent();

	public StudentEntity getStudent(Integer sid);

	public String updateStudent(StudentEntity studentEntity);

	public String deleteStudent(Integer sid);

}
