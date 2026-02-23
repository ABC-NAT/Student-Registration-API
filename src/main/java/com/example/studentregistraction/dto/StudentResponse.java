package com.example.studentregistraction.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@Setter
@ToString
public class StudentResponse {

    private Log id;

    private String studentCode;

    private String fullName;

    private String email;

    private int age;

    private Date createdAt;

}
