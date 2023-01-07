package com.sms.core;

import com.sms.core.entity.Student;
import com.sms.core.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner{

    public static void main(String[] args) {
            SpringApplication.run(SmsApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public void run(String... args) throws Exception {             
//        Student student1 = new Student("Matt", "Wilson", "matt.wson@gmail.com");
//        studentRepository.save(student1);
//        Student student2 = new Student("Marco", "Da'melio", "marco@outlook.com");
//        studentRepository.save(student2);
//        Student student3 = new Student("Will", "Houtson", "will.hson@gmail.com");
//        studentRepository.save(student3);
    }

}
