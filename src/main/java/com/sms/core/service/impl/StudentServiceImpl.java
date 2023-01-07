package com.sms.core.service.impl;

import com.sms.core.entity.Student;
import com.sms.core.repository.StudentRepository;
import com.sms.core.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //https://www.arquitecturajava.com/spring-service-usando-el-patron-servicio/
public class StudentServiceImpl implements StudentService{
    
    @Autowired //para descubir el bean
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) { // Constructor
        this.studentRepository = studentRepository;
    }
    
    @Override
    public List<Student> getAllStudents() { // Funcion extendida DAO
        return studentRepository.findAll();
    }
    
    @Override
    public Student storeStudent(Student student) {
        return studentRepository.save(student); 
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void destroyStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
}
