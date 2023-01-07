package com.sms.core.service;

import com.sms.core.entity.Student;
import java.util.List;

public interface StudentService { //Clase dao
    
    abstract List<Student> getAllStudents();
    abstract Student storeStudent(Student student);
    abstract Student getStudentById(Long id);
    abstract Student updateStudent(Student student);
    abstract void destroyStudent(Long id);
}
