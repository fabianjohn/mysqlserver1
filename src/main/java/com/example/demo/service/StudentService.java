package com.example.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class StudentService {
	
@Autowired

private StudentRepository repo;
public List<Student> listAll()
{
	return repo.findAll();
}
public void save(Student std)
{
	repo.save(std);
}

public Student get(long id)
{
	return repo.findById(id).get();
}
public void delete(long id)
{
	repo.deleteById(id);
}
public Student findById(long id)
{
	return repo.findById(id).get();
}
public void saved(Student std)
{
	repo.save(std);
}

public String getStudentName() {
	return getStudentName();
}

}
