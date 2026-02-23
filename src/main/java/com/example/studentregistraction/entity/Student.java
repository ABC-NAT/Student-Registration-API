package com.example.studentregistraction.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Column(name = "STUDENT_CODE", unique = true, nullable = false)
    private String studentCode;

    @Column(name = "FULL_NAME")
    private String fullName;
    
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;
    
    @Column(name = "AGE")
    private int age;

    @Column(name = "CREATED_AT")
    private Date createdAt;

}
