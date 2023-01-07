package com.sms.core.repository;

import com.sms.core.entity.Student;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

//no es necesario poner @Repository porque la interfaz JpaRepository
//tiene una clase default implementada que tiene la anotacion @Repository
public interface StudentRepository extends JpaRepository<Student, Long>{ //parametros: Clase y Tipo de pk

//    public void save(ArrayList<Student> students);
    
}
