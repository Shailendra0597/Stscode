package com.shailendra.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shailendra.student.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

	Student findBystudentName(String name);
}
