package com.example.studentregistraction.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentUpdateRequest {

    private String fullName;

    private String email;

    private int age;

}
