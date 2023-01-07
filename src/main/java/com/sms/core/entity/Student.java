package com.sms.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //es una anotación que define el componente y que especifica que una clase es una entidad de la bd
@Table(name = "students") // especifica el origen de datos que se debe utilizar en la clase.
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define la columna id PK - AI
    private Long id;
    
    @Column(name = "firstName", nullable = false) //puede ser redundante si las columnas de la bd se llaman igual.
    private String firstName;
    //
    @Column(name = "lastName")
    private String lastName;
    //
    @Column(name = "email", nullable = false)
    private String email;
    //
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public Student() {
    }
    
    
}
