package com.sms.core.controller;

import com.sms.core.entity.Pages;
import com.sms.core.entity.Student;
import com.sms.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired //para descubir el bean
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Metodo para controlar la lista de estudiantes y devolver el modelo y la vista
    @GetMapping(path = {"/students"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTS_VIEW);
        return modelAndView.addObject("students", studentService.getAllStudents());
    }

    @GetMapping(path = {"/students/create"})
    public ModelAndView createStudent() {
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTS_CREATE);
        Student student = new Student();//Crear el objeto student para el formulario
        return modelAndView.addObject("student", student);
    }

    @PostMapping(path = {"/students/store"})
    public ModelAndView storeStudent(@ModelAttribute(name = "student") Student student) {
        studentService.storeStudent(student);
        return new ModelAndView("redirect:/" + Pages.STUDENTS_VIEW);
    }

    @GetMapping(path = "/students/edit/{id}")
    public ModelAndView editStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ModelAndView(Pages.STUDENTS_UPDATE).addObject("student", student);
    }

//    @PostMapping(path = "/students/update/{id}")
    @PostMapping(path = "/students/update")
    public ModelAndView updateStudent(/*@PathVariable Long id,*/ @ModelAttribute Student student) {
//      Forma 1
//      ===================================
        //Obtener al estudiante desde la BD
        /*
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        */
        //Guardar nuevo estudiante
//        studentService.updateStudent(existingStudent);
//      Forma 2
//      ====================================
        studentService.updateStudent(student);
        return new ModelAndView("redirect:/" + Pages.STUDENTS_VIEW);
    }
    
    @GetMapping(path = {"/students/delete/{id}"})
    public ModelAndView destroyStudent(@PathVariable Long id) {
        studentService.destroyStudent(id);
        return new ModelAndView("redirect:/" + Pages.STUDENTS_VIEW);
    }
}
